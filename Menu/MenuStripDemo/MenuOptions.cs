using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace MenuStripDemo
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void blueToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.BackColor = Color.Aqua;
        }

        private void redToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.BackColor = Color.FromArgb(220, 13, 50);
        }

        private void orangeToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.BackColor = Color.FromArgb(255, 138, 58);
        }

        private void italicToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.Font = new Font("Wingdings", 32);
        }

        private void professionalToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.Font = new Font("Tahoma", 12);
        }
    }
}
