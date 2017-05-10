using System.Linq;
using UnityEngine;

public class CarportGenerator : MonoBehaviour
{
    public float length;
    public float width;
    private int pillars = 4;
    private int rafters = 15;

    public GameObject shed;
    public GameObject pillar;
    public GameObject rafter;
    public GameObject waterboard;
    public GameObject roof;
    public GameObject rem;

    private readonly float roofOverload = 0.7f;
    private readonly float remOverload = 0.275f;
    private readonly float slope = 2;

    private void Start ()
    {
        #if !UNITY_EDITOR && UNITY_WEBGL
            WebGLInput.captureAllKeyboardInput = false;
        #endif

        //string url = "http://localhost:8080/FogSoftware-SEM2-A2/FrontController?length=780&width=600&action=create-carport";
        string url = Application.absoluteURL;
        string[] splitSlash = url.Split('/');
        string[] split = splitSlash[splitSlash.Length - 1].Split('&');
        foreach (string str in split)
        {
            if (str.Contains("length"))
            {
                length = float.Parse(GetNumbers(str)) / 100;
            }
            else if (str.Contains("width"))
            {
                width = float.Parse(GetNumbers(str)) / 100;
            }
        }
        pillars = GetPillarAmount();
        rafters = GetRafterAmount();

        // Instantiating the shed //
        GameObject shedInstance = Instantiate(shed, new Vector3(0, 1.05f, 0), Quaternion.identity);
        shedInstance.transform.localScale = new Vector3(width, 2, 2.1f);

        // This handles the rem //
        GameObject remRight = Instantiate(rem, new Vector3(-width / 2 - rem.transform.localScale.z / 2, shedInstance.transform.localScale.y + rem.transform.localScale.y, (length - 2.1f) / 2), Quaternion.Euler(0, 90, -slope));
        remRight.transform.localScale = new Vector3(length + remOverload * 2, remRight.transform.localScale.y, remRight.transform.localScale.z);

        GameObject remLeft = Instantiate(rem, new Vector3(width / 2 + rem.transform.localScale.z / 2, shedInstance.transform.localScale.y + rem.transform.localScale.y, (length - 2.1f) / 2), Quaternion.Euler(0, 90, -slope));
        remLeft.transform.localScale = new Vector3(length + remOverload * 2, remRight.transform.localScale.y, remRight.transform.localScale.z);


        // This handles the positioning of pillars //
        float distance = (length - 2.1f) / (pillars / 2 + 1);
        Vector3 startPosition = new Vector3(width / 2 + pillar.transform.localScale.x / 2, pillar.transform.localScale.y / 2, 2.1f / 2);
        for (int i = 1; i <= pillars / 2; i++)
        {
            GameObject pillar1 = Instantiate(pillar, startPosition + new Vector3(-pillar.transform.localScale.x / 2, 0, distance * i), Quaternion.identity);
            GameObject pillar2 = Instantiate(pillar, startPosition + new Vector3(-width - pillar.transform.localScale.x / 2, 0, distance * i), Quaternion.identity);
            pillar1.transform.localScale += new Vector3(0, CalcHeightForSlope(pillar1, remLeft) * i, 0);
            pillar2.transform.localScale += new Vector3(0, CalcHeightForSlope(pillar2, remLeft) * i, 0);
        }

        // Here the rafters are handled 
        Vector3 rafterStart = new Vector3(0, 0, -2.1f / 2);
        float rafterDistance = length / (rafters - 1);
        for (int i = 0; i < rafters; i++)
        {
            GameObject rafterInstance = Instantiate(rafter, rafterStart + 
                new Vector3(0, // position x //
                remRight.transform.position.y + rafter.transform.localScale.y, // position y //
                rafterDistance * i), Quaternion.Euler(-slope, 0, 0)); // position z //

            rafterInstance.transform.position += new Vector3(0, CalcHeightForSlope(rafterInstance, remRight), 0);
            rafterInstance.transform.localScale = new Vector3(width + roofOverload, rafter.transform.localScale.y, rafter.transform.localScale.z);
        }

        // Here the waterboards are handled with care //
        GameObject waterFront = Instantiate(waterboard, new Vector3(0, 0, remRight.transform.position.z + remRight.transform.localScale.x / 2 + waterboard.transform.localScale.z), Quaternion.Euler(-slope, 0, 0));
        waterFront.transform.localScale = new Vector3(width + roofOverload + 2 * rem.transform.localScale.z, waterFront.transform.localScale.y, waterFront.transform.localScale.z);
        waterFront.transform.position += new Vector3(0, rafter.transform.localScale.y + remRight.transform.position.y + CalcHeightForSlope(waterFront, remRight), -CalcHeightForSlope(waterFront, remRight));
        waterFront.transform.position += new Vector3(0, -0.005f, 0.01f); // Fusk faktor //

        GameObject waterRight = Instantiate(waterboard, new Vector3(-(width + roofOverload) / 2 - waterboard.transform.localScale.z, remRight.transform.position.y + remRight.transform.localScale.y / 2 + rafter.transform.localScale.y / 2, GetCenter(shedInstance)), Quaternion.Euler(0, 90, -slope));
        waterRight.transform.localScale = new Vector3(length + remOverload + 2 * waterRight.transform.localScale.z, waterRight.transform.localScale.y, waterRight.transform.localScale.z);

        GameObject waterLeft = Instantiate(waterboard, new Vector3((width + roofOverload) / 2 + waterboard.transform.localScale.z, remRight.transform.position.y + remRight.transform.localScale.y / 2 + rafter.transform.localScale.y / 2, GetCenter(shedInstance)), Quaternion.Euler(0, 90, -slope));
        waterLeft.transform.localScale = new Vector3(length + remOverload + 2 * waterLeft.transform.localScale.z, waterLeft.transform.localScale.y, waterLeft.transform.localScale.z);

        // Finally the roof is added //
        GameObject roofInstance = Instantiate(roof, new Vector3(0, remRight.transform.position.y + remRight.transform.localScale.y / 2 + rafter.transform.localScale.y + roof.transform.localScale.y, GetCenter(shedInstance)), Quaternion.Euler(-slope, 0, 0));
        roofInstance.transform.localScale = new Vector3(width + roofOverload + 0.2f, roof.transform.localScale.y, length + remOverload + 0.2f);
    }

    private string GetNumbers(string input)
    {
        return new string(input.Where(c => char.IsDigit(c)).ToArray());
    }

    private float CalcHeightForSlope(GameObject obj, GameObject referenceObj)
    {
        return (obj.transform.position.z - referenceObj.transform.position.z) * 0.0349f;
    }

    private float GetCenter(GameObject shedInstance)
    {
        return length / 2 - shedInstance.transform.localScale.z / 2;
    }

    private int GetPillarAmount()
    {
        float carportLength = length - 2.1f; // 2.1 is the length of the shed //

        int num = 2;

        while (carportLength - 1 >= 3.1f)
        {
            num += 2;
            carportLength -= 3.1f;
        }

        return num;
    }

    public int GetRafterAmount()
    {
        float carportLength = length;
        float rafterDistance = 0.55f;

        int rafters = 1;
        while (carportLength > rafterDistance)
        {
            rafters++;
            carportLength -= rafterDistance;
        }
        return rafters;
    }
}