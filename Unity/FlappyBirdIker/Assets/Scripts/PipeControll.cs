using UnityEngine;

public class PipeControll : MonoBehaviour
{

    public Rigidbody rb;

    public float impulseForce = -1;


    // Start is called once before the first execution of Update after the MonoBehaviour is created
    void Start()
    {
        Debug.Log("Hola soy el Start");

        rb = GetComponent<Rigidbody>();
    }

    // Update is called once per frame
    void Update()
    {

        //Darle una fuerza, direccion Up
        rb.AddForce(Vector3.left * impulseForce, ForceMode.Impulse);

    }
}
