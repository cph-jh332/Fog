using UnityEngine;

public class CameraController : MonoBehaviour
{
    public float rotationSpeed;

    Transform plane;
    Vector3 offset;

    private void Start()
    {
        plane = GameObject.Find("Plane").GetComponent<Transform>();
        offset = new Vector3(9, 3, 0);
        transform.position = plane.position;

        transform.position = plane.position + offset;
        transform.LookAt(plane.position);
    }

    private void LateUpdate()
    {
        float scroll = -Input.GetAxis("Mouse ScrollWheel");
        if (scroll < 0 && transform.position.y >= 2.5f || scroll > 0 && transform.position.y < 4)
        {
            offset += (plane.position - transform.position) * 0.2f * -scroll;
        }

        if (Input.GetMouseButton(0))
        {
            offset = Quaternion.AngleAxis(Input.GetAxis("Mouse X") * rotationSpeed, Vector3.up) * offset;
        }

        transform.position = plane.position + offset;
        transform.LookAt(plane.position);
    }
}