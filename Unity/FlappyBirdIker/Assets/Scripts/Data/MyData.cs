using System;
using UnityEngine;

[Serializable]
public class MyData 
{
    [Serializable]
    public struct PlayerStats
    {
        public int puntuacion;
        public string name;

    }


  



    [SerializeField]
    public PlayerStats stats;

  
}
