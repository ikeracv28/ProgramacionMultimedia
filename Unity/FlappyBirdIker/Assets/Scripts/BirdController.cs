using UnityEngine;

public class BirdController : MonoBehaviour

{

    public Rigidbody rb;

    public float gravityForce;

    public float jumpForce;
    

    // Start is called once before the first execution of Update after the MonoBehaviour is created
    void Start()
    {

        Debug.Log("Hola soy el Start");

        rb = GetComponent<Rigidbody>();
        
    }

    // Update is called once per frame
    void Update()
    {
        //Darle una fuerza de gravedad

        rb.AddForce(Vector3.down * gravityForce, ForceMode.Force);


       

        if (Input.GetKeyDown(KeyCode.Space))
        {
            rb.linearVelocity = Vector3.zero;

            //Darle una fuerza, direccion Up
            rb.AddForce(Vector3.up * jumpForce, ForceMode.Impulse);


            

            //Debug.Log("Hola soy el Update");

        }

    }
}
