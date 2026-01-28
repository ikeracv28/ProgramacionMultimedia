using UnityEngine;
using UnityEngine.InputSystem;

public class PlayerControllerGuapardo : MonoBehaviour
{
    public float playerSpeed = 5.0f;
    public float jumpHeight = 3f;
    public float gravityValue = 10f;

    public CharacterController controller;
    private Vector3 playerVelocity;
    public bool groundedPlayer;


    // --- NUEVAS VARIABLES PARA EL DOBLE SALTO ---
    private int jumpCount = 0;
    public int maxJumps = 2; // 2 para doble salto, 3 para triple...


    void Update()
    {
        groundedPlayer = controller.isGrounded;

        if (groundedPlayer)
        {
            // Si tocamos el suelo, reseteamos el contador de saltos
            jumpCount = 0;

            //Esto es para mantenerte en el suelo
            if (playerVelocity.y < -2.0f)
                playerVelocity.y = -2f;
        }

        // Leer input
        Vector2 input;
        input.x = Input.GetAxis("Horizontal");
        input.y = Input.GetAxis("Vertical");

        // si me quiero over hacia la derecha con la D, seria x:-1 y:0 z:0
        Vector3 move = new Vector3(input.x, 0, input.y);
        move = Vector3.ClampMagnitude(move, 1f);

        // si el usuario de esta moviendo (pulsando alguna tecla)
        if (move != Vector3.zero)
            //esto significa que la cara de del muiñeco mire para donde se mueva
            transform.forward = move;

        // --- LÓGICA DE SALTO MEJORADA ---
        if (Input.GetKeyDown(KeyCode.Space))
        {
            // Solo saltamos si estamos en el suelo O si aún nos quedan saltos disponibles
            if (groundedPlayer || jumpCount < maxJumps)
            {
                // Fórmula física: v = sqrt(h * 2 * g) 
                // Usamos 2f por precisión física, pero tu fórmula original también sirve
                playerVelocity.y = Mathf.Sqrt(jumpHeight * 2f * gravityValue);

                // Aumentamos el contador de saltos realizados
                jumpCount++;
            }
        }

        // Para aplicar gravedad
        playerVelocity.y -= gravityValue * Time.deltaTime;

        // Move
        Vector3 finalMove = move * playerSpeed + Vector3.up * playerVelocity.y;
        controller.Move(finalMove * Time.deltaTime);
    }
}