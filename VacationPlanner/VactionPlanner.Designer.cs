
namespace VacationPlanner
{
    partial class VactionPlanner
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.lstDeparture = new System.Windows.Forms.ListBox();
            this.lstRoomType = new System.Windows.Forms.ListBox();
            this.radMealLow = new System.Windows.Forms.RadioButton();
            this.radMealMed = new System.Windows.Forms.RadioButton();
            this.radMealHigh = new System.Windows.Forms.RadioButton();
            this.lblCost = new System.Windows.Forms.Label();
            this.btnCalc = new System.Windows.Forms.Button();
            this.radGroup = new System.Windows.Forms.GroupBox();
            this.radGroup.SuspendLayout();
            this.SuspendLayout();
            // 
            // lstDeparture
            // 
            this.lstDeparture.FormattingEnabled = true;
            this.lstDeparture.Items.AddRange(new object[] {
            "NY",
            "PA",
            "TX",
            "CA"});
            this.lstDeparture.Location = new System.Drawing.Point(155, 59);
            this.lstDeparture.Name = "lstDeparture";
            this.lstDeparture.Size = new System.Drawing.Size(120, 95);
            this.lstDeparture.TabIndex = 0;
            // 
            // lstRoomType
            // 
            this.lstRoomType.FormattingEnabled = true;
            this.lstRoomType.Items.AddRange(new object[] {
            "Generic Room",
            "SMART* Room",
            "KING* SMART* Room",
            "MASTER Room"});
            this.lstRoomType.Location = new System.Drawing.Point(155, 213);
            this.lstRoomType.Name = "lstRoomType";
            this.lstRoomType.Size = new System.Drawing.Size(120, 95);
            this.lstRoomType.TabIndex = 1;
            // 
            // radMealLow
            // 
            this.radMealLow.AutoSize = true;
            this.radMealLow.Location = new System.Drawing.Point(28, 30);
            this.radMealLow.Name = "radMealLow";
            this.radMealLow.Size = new System.Drawing.Size(90, 17);
            this.radMealLow.TabIndex = 2;
            this.radMealLow.TabStop = true;
            this.radMealLow.Text = "Chicken Meal";
            this.radMealLow.UseVisualStyleBackColor = true;
            // 
            // radMealMed
            // 
            this.radMealMed.AutoSize = true;
            this.radMealMed.Location = new System.Drawing.Point(28, 54);
            this.radMealMed.Name = "radMealMed";
            this.radMealMed.Size = new System.Drawing.Size(79, 17);
            this.radMealMed.TabIndex = 3;
            this.radMealMed.TabStop = true;
            this.radMealMed.Text = "Steak Meal";
            this.radMealMed.UseVisualStyleBackColor = true;
            // 
            // radMealHigh
            // 
            this.radMealHigh.AutoSize = true;
            this.radMealHigh.Location = new System.Drawing.Point(28, 78);
            this.radMealHigh.Name = "radMealHigh";
            this.radMealHigh.Size = new System.Drawing.Size(105, 17);
            this.radMealHigh.TabIndex = 4;
            this.radMealHigh.TabStop = true;
            this.radMealHigh.Text = "Specialized Meal";
            this.radMealHigh.UseVisualStyleBackColor = true;
            // 
            // lblCost
            // 
            this.lblCost.AutoSize = true;
            this.lblCost.Location = new System.Drawing.Point(524, 268);
            this.lblCost.Name = "lblCost";
            this.lblCost.Size = new System.Drawing.Size(58, 13);
            this.lblCost.TabIndex = 5;
            this.lblCost.Text = "Total Cost:";
            // 
            // btnCalc
            // 
            this.btnCalc.Location = new System.Drawing.Point(524, 213);
            this.btnCalc.Name = "btnCalc";
            this.btnCalc.Size = new System.Drawing.Size(180, 39);
            this.btnCalc.TabIndex = 6;
            this.btnCalc.Text = "Calculate";
            this.btnCalc.UseVisualStyleBackColor = true;
            this.btnCalc.Click += new System.EventHandler(this.btnCalc_Click);
            // 
            // radGroup
            // 
            this.radGroup.Controls.Add(this.radMealHigh);
            this.radGroup.Controls.Add(this.radMealMed);
            this.radGroup.Controls.Add(this.radMealLow);
            this.radGroup.Location = new System.Drawing.Point(496, 29);
            this.radGroup.Name = "radGroup";
            this.radGroup.Size = new System.Drawing.Size(175, 124);
            this.radGroup.TabIndex = 7;
            this.radGroup.TabStop = false;
            // 
            // VactionPlanner
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.radGroup);
            this.Controls.Add(this.btnCalc);
            this.Controls.Add(this.lblCost);
            this.Controls.Add(this.lstRoomType);
            this.Controls.Add(this.lstDeparture);
            this.Name = "VactionPlanner";
            this.Text = "Vaction Planner";
            this.radGroup.ResumeLayout(false);
            this.radGroup.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.ListBox lstDeparture;
        private System.Windows.Forms.ListBox lstRoomType;
        private System.Windows.Forms.RadioButton radMealLow;
        private System.Windows.Forms.RadioButton radMealMed;
        private System.Windows.Forms.RadioButton radMealHigh;
        private System.Windows.Forms.Label lblCost;
        private System.Windows.Forms.Button btnCalc;
        private System.Windows.Forms.GroupBox radGroup;
    }
}

