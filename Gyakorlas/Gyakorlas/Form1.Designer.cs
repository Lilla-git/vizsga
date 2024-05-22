namespace Gyakorlas
{
    partial class Form1
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
            this.lb_termek = new System.Windows.Forms.ListBox();
            this.lbl_darab = new System.Windows.Forms.Label();
            this.lbl_ar = new System.Windows.Forms.Label();
            this.btn_vetel = new System.Windows.Forms.Button();
            this.lb_kosar = new System.Windows.Forms.ListBox();
            this.lbl_osszeg = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // lb_termek
            // 
            this.lb_termek.FormattingEnabled = true;
            this.lb_termek.Location = new System.Drawing.Point(33, 38);
            this.lb_termek.Name = "lb_termek";
            this.lb_termek.Size = new System.Drawing.Size(120, 238);
            this.lb_termek.TabIndex = 0;
            this.lb_termek.SelectedIndexChanged += new System.EventHandler(this.lb_termek_SelectedIndexChanged);
            // 
            // lbl_darab
            // 
            this.lbl_darab.AutoSize = true;
            this.lbl_darab.Location = new System.Drawing.Point(237, 72);
            this.lbl_darab.Name = "lbl_darab";
            this.lbl_darab.Size = new System.Drawing.Size(35, 13);
            this.lbl_darab.TabIndex = 1;
            this.lbl_darab.Text = "label1";
            // 
            // lbl_ar
            // 
            this.lbl_ar.AutoSize = true;
            this.lbl_ar.Location = new System.Drawing.Point(237, 108);
            this.lbl_ar.Name = "lbl_ar";
            this.lbl_ar.Size = new System.Drawing.Size(35, 13);
            this.lbl_ar.TabIndex = 2;
            this.lbl_ar.Text = "label1";
            // 
            // btn_vetel
            // 
            this.btn_vetel.Location = new System.Drawing.Point(226, 226);
            this.btn_vetel.Name = "btn_vetel";
            this.btn_vetel.Size = new System.Drawing.Size(75, 23);
            this.btn_vetel.TabIndex = 3;
            this.btn_vetel.Text = "kosarba";
            this.btn_vetel.UseVisualStyleBackColor = true;
            this.btn_vetel.Click += new System.EventHandler(this.btn_vetel_Click);
            // 
            // lb_kosar
            // 
            this.lb_kosar.FormattingEnabled = true;
            this.lb_kosar.Location = new System.Drawing.Point(375, 38);
            this.lb_kosar.Name = "lb_kosar";
            this.lb_kosar.Size = new System.Drawing.Size(120, 238);
            this.lb_kosar.TabIndex = 4;
            // 
            // lbl_osszeg
            // 
            this.lbl_osszeg.AutoSize = true;
            this.lbl_osszeg.Location = new System.Drawing.Point(527, 72);
            this.lbl_osszeg.Name = "lbl_osszeg";
            this.lbl_osszeg.Size = new System.Drawing.Size(35, 13);
            this.lbl_osszeg.TabIndex = 5;
            this.lbl_osszeg.Text = "label1";
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.lbl_osszeg);
            this.Controls.Add(this.lb_kosar);
            this.Controls.Add(this.btn_vetel);
            this.Controls.Add(this.lbl_ar);
            this.Controls.Add(this.lbl_darab);
            this.Controls.Add(this.lb_termek);
            this.Name = "Form1";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.ListBox lb_termek;
        private System.Windows.Forms.Label lbl_darab;
        private System.Windows.Forms.Label lbl_ar;
        private System.Windows.Forms.Button btn_vetel;
        private System.Windows.Forms.ListBox lb_kosar;
        private System.Windows.Forms.Label lbl_osszeg;
    }
}

