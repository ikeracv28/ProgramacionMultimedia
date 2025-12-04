using TMPro;
using Unity.VisualScripting;
using UnityEngine;
using UnityEngine.SceneManagement;
using UnityEngine.UI;

public class BirdController : MonoBehaviour

{

    private Rigidbody rb;

    public float gravityForce;

    public float jumpForce;

    public GameObject pauseMenuGO;

    public GameObject scoreInGameText;

    public int score;

    private TMP_Text textScore;

    private TMP_Text textNumberScorePanel;




    public float PipeSpeed;

    // Start is called once before the first execution of Update after the MonoBehaviour is created
    void Start()
    {

        Debug.Log("Hola soy el Start");

        rb = GetComponent<Rigidbody>();

        textScore = scoreInGameText.GetComponent<TMP_Text>();

        textNumberScorePanel = pauseMenuGO.transform.GetChild(1).GetChild(1).GetComponent<TMP_Text>();



    }

    // Update is called once per frame
    void Update()
    {
        //Darle una fuerza de gravedad

        rb.AddForce(Vector3.down * gravityForce * Time.deltaTime, ForceMode.Force);


       

        if (Input.GetKeyDown(KeyCode.Space))
        {
            rb.linearVelocity = Vector3.zero;

            //Darle una fuerza, direccion Up
            rb.AddForce(Vector3.up * jumpForce, ForceMode.Impulse);

         

            //Debug.Log("Hola soy el Update");
        }

    }

    private void OnCollisionEnter(Collision collision)
    {
        // esto es para que si detecta que choque contra lo que le pongamos el tag pipe
        if(collision.gameObject.tag == "Pipe")
        {
            // se Pause el juego
            Time.timeScale = 0.0F;
            PausaMenu();
            MostrarTexto();
        }

        Debug.Log("He chocado con: " + collision.gameObject.tag);
    }

    private void OnTriggerEnter(Collider other)
    {
        Debug.Log("He chocado con un triggeer: " + other.gameObject.name);
        score++;
        textScore.text = score.ToString();
        textNumberScorePanel.text = score.ToString();
    }

    public void PausaMenu()
    {
        pauseMenuGO.SetActive(true);
    }

    public void MostrarTexto()
    {
        scoreInGameText.SetActive(false);
        
    }

    public void Restart()
    {
        SceneManager.LoadScene(0);
        Time.timeScale = 1.0F;
    }
}
