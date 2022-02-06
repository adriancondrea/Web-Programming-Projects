using System;
namespace Dealership.Models
{
    public class Car
    {
        public int Id { get; set; }

        public string Brand { get; set; }

        public string Model { get; set; }

        public int ProductionYear { get; set; }

        public float EnginePower { get; set; }

        public string Fuel { get; set; }

        public string Color { get; set; }

        public int Price { get; set; }


        public Car()
        {

        }
    }
}
