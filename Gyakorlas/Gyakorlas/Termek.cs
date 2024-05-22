using System;
using System.Collections.Generic;
using System.Linq;
using System.Management.Instrumentation;
using System.Text;
using System.Threading.Tasks;

namespace Gyakorlas
{
    internal class Termek
    {
        public Termek(string nev, int darab, int ar)
        {
            Nev = nev;
            Darab = darab;
            Ar = ar;
        }

        public string Nev { get; set; }
        public int Darab { get; set; }
        public int Ar { get; set; }
    }
}
