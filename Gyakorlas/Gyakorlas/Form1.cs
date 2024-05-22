using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Gyakorlas
{
    public partial class Form1 : Form
    {
        static List<Termek> termekek = new List<Termek>();// Termekek lista ami Termek tipust tarol
        static int osszeg = 0;
        public Form1()
        {
            InitializeComponent();
            Beolvas();
            Hozzaad();
        }

        private void Hozzaad()
        { //Hozzaadja a listabocóx-hoz az elemek nevet
            foreach (var termek in termekek)// termek az adat , termekek a lista
            {
                lb_termek.Items.Add(termek.Nev);//Hozzaadjuk a listabox-hoz a termek  nevet.
            }
        }

        private void Beolvas()
        {
            StreamReader sr = new StreamReader("termekek.txt"); // Megadjuk, hogy melyik file-t kell beolvasni
            sr.ReadLine(); // Van fejléc a file-ban
            string[] adatok;
            while (!sr.EndOfStream) //Addig megy amíg tart a file tartalma
            {
                adatok = sr.ReadLine().Split(';'); // Feldarabolja a sort a pontosvesszőnél
                termekek.Add(new Termek(adatok[0], int.Parse(adatok[1]), int.Parse(adatok[2])));//Hozzáadjuk az adatokat a termekek listahoz(int.Pasrse(az adat)-azert kell,hogy szamkent tudjuk eltarolni a kapott adatot. Segitsegnek tt a class.
            }
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void lb_termek_SelectedIndexChanged(object sender, EventArgs e)
        {
            foreach (var item in termekek) // veigmegy a termekek listan
            {
                if (lb_termek.SelectedItem.ToString() == item.Nev) // Megvizsgaljuk a kivalaszttt termeknek a nevet,hogy egyezik-e a felvett termek nevevel
                {
                    lbl_darab.Text = item.Darab + "db"; // A Labal szovege legyen = a kivalasztott item darabjaval + "db";
                    lbl_ar.Text = item.Ar + "Ft"; // A Label szovege legyen = a kivalasztott item araval + "Ft"(Ha nincs a + 'Ft' akkor kell a .ToString().
                }
            }

        }

        private void btn_vetel_Click(object sender, EventArgs e)
        {
            lb_kosar.Items.Add(lb_termek.SelectedItem.ToString());// A kosar ListBoc-hoz hozzaadjuk a kivalasztott elemet
            foreach (var termek in termekek)//Vegigmegy a termekek listan.
            {
                if(lb_termek.SelectedItem.ToString() == termek.Nev)
                { 
                    termek.Darab -= 1;//Termek 
                    if (termek.Darab > 0)
                    {
                        lbl_darab.Text = termek.Darab + "db";
                        osszeg += termek.Ar;
                        lbl_osszeg.Text = osszeg + "Ft";
                    }
                    else
                    {
                        lbl_darab.Text = "db";
                        MessageBox.Show("Elfogyott a termek", "Hiba");
                    }   
                }

            }

        }
    }
}
