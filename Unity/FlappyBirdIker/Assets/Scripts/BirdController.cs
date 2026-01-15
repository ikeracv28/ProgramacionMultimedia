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

    private bool pausePanelInterruptor = true;

    private bool estaVivo = true;

    public AudioSource sFXGameOver;

    public AudioSource tapSound;

    public AudioSource sFXAmbientSound;


    // Start is called once before the first execution of Update after the MonoBehaviour is created
    void Start()
    {

        Debug.Log("Hola soy el Start");

        rb = GetComponent<Rigidbody>();

        textScore = scoreInGameText.GetComponent<TMP_Text>();

        textNumberScorePanel = pauseMenuGO.transform.GetChild(1).GetChild(1).GetComponent<TMP_Text>();

        //sFXGameOver = GetComponent<AudioSource>();

        //tapSound = GetComponent<AudioSource>();

        sFXAmbientSound.Play();

    }

    // Update is called once per frame
    void Update()
    {
        //Darle una fuerza de gravedad

        rb.AddForce(Vector3.down * gravityForce * Time.deltaTime, ForceMode.Force);


       

        if (Input.GetKeyDown(KeyCode.Space))
        {
            tapSound.Play();

            rb.linearVelocity = Vector3.zero;

            //Darle una fuerza, direccion Up
            rb.AddForce(Vector3.up * jumpForce, ForceMode.Impulse);

            

            //Debug.Log("Hola soy el Update");
        }

        // para pausar el juego dando al escape
        if (Input.GetKeyDown(KeyCode.Escape) == true && pausePanelInterruptor == false)
        {

            PausaMenu(false);
            pausePanelInterruptor = true;


        }

        // para pausar el juego
        else if (Input.GetKeyDown(KeyCode.Escape) == true && pausePanelInterruptor == true)
        {
            
            PausaMenu(true);
            pausePanelInterruptor=false;

        }
       

    }

    private void OnCollisionEnter(Collision collision)
    {
        // esto es para que si detecta que choque contra lo que le pongamos el tag pipe
        if(collision.gameObject.tag == "Pipe")
        {
            // se Pause el juego cuando mueres
            Death();
            //this.enabled = false;

        }

        Debug.Log("He chocado con: " + collision.gameObject.tag);
    }

    private void OnTriggerEnter(Collider other)
    {
        Debug.Log("He chocado con un triggeer: " + other.gameObject.name);
        score++;
        textScore.text = score.ToString();
        textNumberScorePanel.text = score.ToString();
        DataSaver dataSaver = new DataSaver();
        dataSaver.Load();

        if(score % 5 == 0)
        {
            PipeSpeed += 1.0f;
        }
    }

    // este va a ser sobre todo paraa cuando le demos al escape para pararlos
    public void PausaMenu(bool active)
    {
        if(active == true)
        {
            // se Pause el juego
            Time.timeScale = 0.0F;
            pauseMenuGO.SetActive(true);
            scoreInGameText.SetActive(false);
        }
        else if(active == false && estaVivo == true)
        {
            // se Pause el juego
            Time.timeScale = 1.0F;
            pauseMenuGO.SetActive(false);
            scoreInGameText.SetActive(true);
        }
    }

    // aquui es para cuando chocamos, y hemos muerto en el juego
    public void Death()
    {
        // para controlar que si es porque ha muerto no pueda darle al escape y continuar el juego
        estaVivo = false;

        // se Pause el juego
        Time.timeScale = 0.0F;
        pauseMenuGO.SetActive(true);
        scoreInGameText.SetActive(false);
        sFXGameOver.Play();
        sFXAmbientSound.Stop();
    }



   

    public void Restart()
    {
        SceneManager.LoadScene(1);
        Time.timeScale = 1.0F;
    }
}
