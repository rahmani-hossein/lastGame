package swing.button;

import client.Controller;
import logic.ShopManager;
import swing.panel.CardPanel;
import swing.panel.FilterPanel;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

public class Button implements MouseListener {

    private BufferedImage image;
    private String name;
    private ShopManager shopManager = new ShopManager(Controller.getInstance().getGameState().getPlayer());
    private int width;
    private int height;
    private int sizeW=200;
    private int sizeH=275;
    CardPanel cardPanel;

    public int getSizeW() {
        return sizeW;
    }

    public void setSizeW(int sizeW) {
        this.sizeW = sizeW;
    }

    public int getSizeH() {
        return sizeH;
    }

    public void setSizeH(int sizeH) {
        this.sizeH = sizeH;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Button(BufferedImage image, String name, int width, int height) {
        this.image = image;
        this.name = name;
        this.width=width;
        this.height=height;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public void paint(Graphics g){
        g.drawImage(this.image,this.width,this.height,this.sizeW,this.sizeH,null);
       // System.out.println(this.name+"painted");
    }

    public void hidePanel(){
        cardPanel.setVisible(false);
    }

    public void makePanel(FilterPanel filterPanel) {

         cardPanel = new CardPanel(this.getName(), shopManager);
        int cardWidth = this.width;
        int cardHeight =this.height ;
        cardPanel.setSize(cardWidth, cardHeight);
        cardPanel.setVisible(true);
        filterPanel.add(cardPanel);
        cardPanel.setBounds(width,height,sizeW,sizeH);
        filterPanel.getCardPanels().add(cardPanel);



//            showButton.get(i).addMouseListener(new MouseListener() {
//                @Override
//                public void mouseClicked(MouseEvent e) {
//
//                }
//
//                @Override
//                public void mousePressed(MouseEvent e) {
//
//                }
//
//                @Override
//                public void mouseReleased(MouseEvent e) {
//
//                }
//
//                @Override
//                public void mouseEntered(MouseEvent e) {
//                    cardPanel.setBounds(e.getX(), e.getY() - cardWidth, cardWidth, cardHeight);
//                    setVisible(true);
//                    repaint();
//                    revalidate();
//                }
//
//                @Override
//                public void mouseExited(MouseEvent e) {
//                    setVisible(false);
//                    repaint();
//                    revalidate();
//                }
//            });
//        }
//
//


    }

    @Override
    public void mouseClicked(MouseEvent e) {
//        if ((e.getX()>=width)&&(e.getX()<=width+sizeW)&&(e.getY()>=height)&&(e.getY()<=height+sizeH)){
//            System.out.println("button clicked");
//            makePanel();
//        }
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
