using UnityEngine;

public class PipeControll : MonoBehaviour
{

    public Rigidbody rb;

    //public float impulseForce = -1;

    public float speed;

    public float xLimit;



    public float random;

    public BirdController pajaro;




    // Start is called once before the first execution of Update after the MonoBehaviour is created
    void Start()
    {
        Debug.Log("Hola soy el Start");

        //rb = GetComponent<Rigidbody>();
    }

    // Update is called once per frame
    void Update()
    {

        if(transform.position.x < -xLimit)
        {
            transform.position = new Vector3(xLimit, Random.Range(-3.0f, 4.0f) , 0.0f);
        }

        transform.position += new Vector3(-pajaro.PipeSpeed, 0.0f, 0.0f) * Time.deltaTime;

        //Darle una fuerza, direccion Up
        //rb.AddForce(Vector3.left * impulseForce, ForceMode.Impulse);

    }
}
