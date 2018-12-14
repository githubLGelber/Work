using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Reflection;
using System.Windows.Forms;
using Common;
using Common.Business_Objects;

namespace GalaxyCinemas
{
    public partial class MainForm : Form
    {
        private List<ISpecialPlugin> specialPlugins = new List<ISpecialPlugin>();
        public MainForm()
        {
            InitializeComponent();
            try
            {
                DirectoryInfo dir = new DirectoryInfo(Application.StartupPath);

                foreach (FileInfo file in dir.GetFiles("Plugin*.dll"))
                {
                    string name = Path.GetFileNameWithoutExtension(file.Name);

                    Assembly assem = Assembly.Load(name);

                    var plugins = from type in assem.GetTypes()
                                  where typeof(ISpecialPlugin).IsAssignableFrom(type)
                                  select type;

                    foreach (Type plugin in plugins)
                    {
                        ISpecialPlugin plug = Activator.CreateInstance(plugin) as ISpecialPlugin;
                        specialPlugins.Add(plug);
                    }


                }
            }
            catch (Exception e)
            {
                Console.WriteLine("Error occurred while loading special pricing plugins");
                Console.WriteLine(e.Message);
            }
        }

        private void MainForm_Load(object sender, EventArgs e)
        {

        }

        private void btnClose_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void btnImport_Click(object sender, EventArgs e)
        {
            ImportDataForm idf = new ImportDataForm();
            idf.FormClosed += ChildFormClosed;
            idf.Show();
        }

        private void btnExport_Click(object sender, EventArgs e)
        {
            ExportDataForm edf = new ExportDataForm();
            edf.FormClosed += ChildFormClosed;
            edf.Show();
        }

        private void btnBook_Click(object sender, EventArgs e)
        {
            BookingForm bf = new BookingForm(specialPlugins);
            bf.FormClosed += ChildFormClosed;
            bf.Show();
        }
        private void ChildFormClosed(object sender, FormClosedEventArgs e)
        {
            // To ensure the main form has focus after a child form is closed.
            this.Focus();
        }
    }
}
