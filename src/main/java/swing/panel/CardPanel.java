package swing.panel;

import CLI.utilities;
import client.Controller;
import logic.CardManager;
import logic.Constans;
import logic.ShopManager;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CardPanel extends JPanel implements MouseListener {
    ShopManager shopManager;
    private Constans constans=Controller.getInstance().getConstants();
    private CardManager cardManager;
    private String name;
    private int cost=0;
    private String type="";
    private String rarity;
    private JLabel info1;
    private JLabel info2;
    private JLabel info3;
   private JLabel info4;
    private JButton sell;
    private JButton buy;
    private JButton exit;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public JButton getSell() {
        return sell;
    }

    public void setSell(JButton sell) {
        this.sell = sell;
    }

    public JButton getBuy() {
        return buy;
    }

    public void setBuy(JButton buy) {
        this.buy = buy;
    }

    public CardPanel(String name, ShopManager shopManager ){
        this.cardManager=new CardManager();
        this.shopManager=shopManager;
        this.name=name;
//        System.out.println(Constans.costsMap);
        this.cost= constans.getCostsMap().get(name);
        this.type=constans.getTypes().get(name);
        this.rarity=cardManager.tellRarity(name);
        setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
        info1=new JLabel("name:"+name);
        info2=new JLabel("cost:"+cost);
        info3=new JLabel("type:"+type);
        info4=new JLabel("rarity:"+rarity);
        sell=new JButton("sell");
        buy=new JButton("buy");
        exit=new JButton("exit");
        exit.addMouseListener(this);
        sell.addMouseListener(this);
        buy.addMouseListener(this);
        add(info1);
        add(info2);
        add(info3);
        add(info4);
        add(sell);
        add(buy);
        add(exit);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource()==buy) {
            if (shopManager.canBuy(name)) {
                int action = JOptionPane.showConfirmDialog(getParent(), "do you want to buy?", "buy Title", JOptionPane.OK_CANCEL_OPTION);
                if (action == JOptionPane.OK_OPTION) {
                    shopManager.buy(name);
                    String st1 = String.format("%s.txt", Controller.getInstance().getGameState().getPlayer().getUsername() +  Controller.getInstance().getGameState().getPlayer().getPassword());
                    Controller.myLogger(st1,"you buy "+name+" "+ utilities.time()+"\n",true);
                }
            } else {
                JOptionPane.showMessageDialog(getParent(), "you can not buy this card ", "Error", JOptionPane.ERROR);
                String st1 = String.format("%s.txt", Controller.getInstance().getGameState().getPlayer().getUsername() +  Controller.getInstance().getGameState().getPlayer().getPassword());
                Controller.myLogger(st1," you can not buy "+name+" "+ utilities.time()+"\n",true);
            }
        }
        else if (e.getSource()==sell) {
            if (shopManager.canSell(name)) {
                int action = JOptionPane.showConfirmDialog(getParent(), "do you want to sell?", "Sell Title", JOptionPane.OK_CANCEL_OPTION);
                if (action == JOptionPane.OK_OPTION) {
                    shopManager.sell(name);
                    String st1 = String.format("%s.txt", Controller.getInstance().getGameState().getPlayer().getUsername() +  Controller.getInstance().getGameState().getPlayer().getPassword());
                    Controller.myLogger(st1,"you sell "+name+" "+ utilities.time()+"\n",true);
                }
            } else {
                JOptionPane.showMessageDialog(getParent(), "you can not sell this card ", "Error", JOptionPane.ERROR_MESSAGE);
                String st1 = String.format("%s.txt", Controller.getInstance().getGameState().getPlayer().getUsername() +  Controller.getInstance().getGameState().getPlayer().getPassword());
                Controller.myLogger(st1,"you can not sell "+name+" "+ utilities.time()+"\n",true);
            }
        }
        else if (e.getSource()==exit){
            this.setVisible(false);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
