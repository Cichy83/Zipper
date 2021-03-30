import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.SQLOutput;

public class FileZipper extends JFrame {

    public FileZipper(){
    this.setTitle("Zipper");
    this.setBounds(300,300,250,250);
    this.setJMenuBar(pasekMenu);
    JMenu menuPlik = pasekMenu.add(new JMenu("Plik"));


    Action akcjaDodawania = new Akcja("Dodaj", "Dodaj nowy wpis do archiwum", "ctrl D", new ImageIcon("dodaj.png"));
    Action akcjaUsuwania  = new Akcja("Usuń", "Usuń zazanczony/zaznaczone wspis(y) z archiwum", "ctrl U", new ImageIcon("usun.png"));
    Action akcjaZipowania = new Akcja("Zip", "Zipuj", "ctrl Z");

    JMenuItem menuOtworz = menuPlik.add(akcjaDodawania);
    JMenuItem menuUsun   = menuPlik.add(akcjaUsuwania);
    JMenuItem menuZip    = menuPlik.add(akcjaZipowania);

    bDodaj = new JButton(akcjaDodawania);
    bUsun  = new JButton(akcjaUsuwania);
    bZip   = new JButton(akcjaZipowania);
    lista.setBorder(BorderFactory.createEtchedBorder());

    GroupLayout layout = new GroupLayout(this.getContentPane());
    layout.setAutoCreateContainerGaps(true);
    layout.setAutoCreateGaps(true);

    layout.setHorizontalGroup(
            layout.createSequentialGroup()
            .addComponent(lista, 100, 150,Short.MAX_VALUE)
            .addContainerGap(0,Short.MAX_VALUE)
            .addGroup(
                    layout.createParallelGroup().addComponent(bDodaj).addComponent(bUsun).addComponent(bZip)
            )
    );
    layout.setVerticalGroup(
            layout.createParallelGroup()
            .addComponent(lista, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup().addComponent(bDodaj).addComponent(bUsun).addGap(5,40,Short.MAX_VALUE).addComponent(bZip))
    );

    this.getContentPane().setLayout(layout);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.pack();
    }

    private JList lista = new JList();
    private JButton bDodaj;
    private JButton bUsun;
    private JButton bZip;
    private JMenuBar pasekMenu = new JMenuBar();

    private class Akcja extends AbstractAction{

        public Akcja(String nazwa, String opis, String klawiaturowySkrot){
            this.putValue(Action.NAME, nazwa);
            this.putValue(Action.SHORT_DESCRIPTION, opis);
            this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(klawiaturowySkrot));
        }
        public Akcja(String nazwa, String opis, String klawiaturowySkrot, Icon ikona){
            this(nazwa, opis, klawiaturowySkrot);
            this.putValue(Action.SMALL_ICON,ikona);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Dodaj"))
                System.out.println("Dodawanie");
            else if (e.getActionCommand().equals("Usuń"))
                System.out.println("Usuwanie");
            else if (e.getActionCommand().equals("Zip"))
                System.out.println("Zipowanie");
        }
    }


    public static void main(String[] args) {
        new FileZipper().setVisible(true);
    }
}
