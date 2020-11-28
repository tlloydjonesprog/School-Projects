using System;
using System.Linq;
using System.Windows.Forms;

namespace VacationPlanner
{
    public partial class VactionPlanner : Form
    {
        public VactionPlanner()
        {
            InitializeComponent();
        }
        public int totalCost = 0;
        private void btnCalc_Click(object sender, EventArgs e)
        {
            totalCost = 0;
            int depart = Depart;
            switch (depart)
            {
                case 0:
                    totalCost += 1000;
                    break;
                case 1:
                    totalCost += 1500;
                    break;
                case 2:
                    totalCost += 2000;
                    break;
                case 3:
                    totalCost += 2505;
                    break;

            }
            int room = Room;
            switch (room)
            {
                case 0:
                    totalCost += 10;
                    break;
                case 1:
                    totalCost += 15;
                    break;
                case 2:
                    totalCost += 30;
                    break;
                case 3:
                    totalCost += 50;
                    break;

            }
            if(getMeal() == "Chicken Meal") { totalCost += 10; }
            if (getMeal() == "Steak Meal") { totalCost += 15; }
            if (getMeal() == "Specialized Meal") { totalCost += 20; }
            if (getMeal() == "") { totalCost += 0; }
            lblCost.Text = (" Total Cost = $" + totalCost.ToString());
        }

        private string getMeal()
        {
            foreach(object a in radGroup.Controls)
            {
                if(a is RadioButton)
                {
                    if(((RadioButton) a).Checked){
                        return  ((System.Windows.Forms.RadioButton)a).Text;
                    }
                }
            }
            return "";
        }
        private int Room => Int32.Parse(lstRoomType.SelectedIndex.ToString());
        private int Depart => Int32.Parse(lstDeparture.SelectedIndex.ToString());
       

    }
}
