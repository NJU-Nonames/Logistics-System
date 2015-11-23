/**
 * 2015年11月19日
 *author:
 *description:
 */
package presentation.courierui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import presentation.img.Img;
import presentation.mainui.CurrentUser;
import presentation.mainui.MainFrame;
import presentation.mainui.MyButton;

/**
 * @author 谭期友
 *
 */
public class SearchPkgInformation extends JPanel{

	private static final long serialVersionUID = -1194559040892610991L;
	//private AccountBLService bl;
	private CourierFrame frame;
	private CurrentUser currentUser;
	
	//最基本按钮
	private MyButton close;
	private MyButton min;
	private MyButton _return;
	//功能按钮
	private MyButton goto_SendPkg;
	private MyButton goto_ReceivePkg;
	private MyButton goto_SearchPkgInformation;
	//详细操作按钮以及其他组件
	private MyButton search;

	private JTextField order;	
	private JLabel name1Label;
	private JLabel phone1Label;
	private JLabel add1Label;
	private JLabel name2Label;
	private JLabel phone2Label;
	private JLabel add2Label;
	private JLabel nameLabel;
	private JLabel weightLabel;
	private JLabel vLabel;
	private JLabel priceLabel;
	private JLabel senddateLabel;
	private DefaultTableModel detailTableModel;
	private JTable detailTable;

	private boolean willprintMessage;//是否将要打印消息
	private String result;//打印的消息
	private Color co;//消息的颜色

	protected void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(Color.WHITE);
        g.drawLine(CourierFrame.w/6, 10, CourierFrame.w/6, CourierFrame.h-10);
        g.drawLine(CourierFrame.w/6+10, CourierFrame.h/6, CourierFrame.w, CourierFrame.h/6);
        g.drawLine(CourierFrame.w/6+20, 128+80+30, CourierFrame.w-20, 128+80+30);

        if(willprintMessage){
        	g.drawImage(Img.BLACK_BG, 0, CourierFrame.h-50, CourierFrame.w, 50, null);
        	
            g.setColor(co);
            g.setFont(new Font("宋体", Font.BOLD, 26));
            g.drawString(result, -result.length()*13+CourierFrame.w/2, 13+CourierFrame.h-30);
        }
	}
	
	public SearchPkgInformation(CourierFrame frame, CurrentUser currentUser){
		this.frame=frame;
		//this.bl=bl;
		this.currentUser=currentUser;
		willprintMessage=false;
		result="";
		co=Color.RED;
		this.setLayout(null);

		//初始化组件
		initComponent();
	}
	private void initComponent() {
		//最基本按钮
		close = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
        close.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
        min = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
        min.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				frame.setExtendedState(JFrame.ICONIFIED);
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
        _return = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
        _return.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				frame.dispose();
				new MainFrame();
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
        //功能按钮
        goto_SendPkg = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
        goto_SendPkg.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				clear();
				frame.setStated(frame.getState());
				frame.setState(1);
				frame.setChanged(true);
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
        goto_ReceivePkg = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
        goto_ReceivePkg.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				clear();
				frame.setStated(frame.getState());
				frame.setState(2);
				frame.setChanged(true);
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
        goto_SearchPkgInformation = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
        goto_SearchPkgInformation.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				clear();
				frame.setStated(frame.getState());
				frame.setState(3);
				frame.setChanged(true);
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
    	//详细操作按钮
        search = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
        search.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				_search();
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
    	
    	//最基本元素
        JLabel titleLabel = new JLabel("物流信息管理系统");
        titleLabel.setSize((int)(50*8*1.07f), 50);
        titleLabel.setFont(new Font("宋体", Font.BOLD, 50));
        titleLabel.setForeground(Color.BLUE);
        titleLabel.setLocation(596-(int)(50*8*1.07f)/2,20);

        String func="快递信息查询";
        JLabel funLabel = new JLabel(func);
        funLabel.setSize((int)(40*func.length()*1.07f), 40);
        funLabel.setFont(new Font("宋体", Font.BOLD, 40));
        funLabel.setLocation(596-(int)(40*func.length()*1.07f)/2,128+10);

        String s="快递员";
        JLabel currentuserLabel = new JLabel(s);
        currentuserLabel.setSize((int)(30*s.length()*1.07f), 30);
        currentuserLabel.setFont(new Font("宋体", Font.BOLD, 30));
        currentuserLabel.setLocation(CourierFrame.w/6,128-30);
        
        JLabel currentusernameLabel = new JLabel(currentUser.getname());
        currentusernameLabel.setSize((int)(30*currentUser.getname().length()*1.07f), 30);
        currentusernameLabel.setFont(new Font("宋体", Font.BOLD, 30));
        currentusernameLabel.setForeground(Color.RED);
        currentusernameLabel.setLocation(CourierFrame.w/6+(int)(30*s.length()*1.07f),128-30);
    	//最基本按钮
    	close.setLocation(CourierFrame.w-30,0);
    	min.setLocation(CourierFrame.w-80,0);
    	_return.setLocation(20,50);
    	//功能按钮
    	goto_SendPkg.setLocation(20,150);
    	goto_ReceivePkg.setLocation(20,200);
    	goto_SearchPkgInformation.setLocation(20,250);
    	
    	//其他组件
		JLabel ordernum = new JLabel("订单编号：");
		ordernum.setSize((int)(16*5*1.07f), 16);
		ordernum.setFont(new Font("宋体", Font.BOLD, 15));
		ordernum.setLocation(CourierFrame.w/6+40, 128+80);
        order = new JTextField();
        order.setSize(110, 20);
        order.setLocation(CourierFrame.w/6+40+(int)(16*5*1.07f),128+80-3);


        JLabel base = new JLabel("快递基本信息");
        base.setSize((int)(22*6*1.07f), 22);
        base.setFont(new Font("宋体", Font.BOLD, 21));
        base.setLocation(300, 128+80+50);

        JLabel l21 = new JLabel("寄件人姓名：");
		l21.setSize((int)(16*6*1.07f), 16);
		l21.setFont(new Font("宋体", Font.BOLD, 15));
        l21.setLocation(CourierFrame.w/6+40, 128+80+100);
        name1Label = new JLabel("实打实的");
        name1Label.setSize((int)(16*6*1.07f), 16);
        name1Label.setFont(new Font("宋体", Font.BOLD, 15));
        name1Label.setForeground(Color.RED);
        name1Label.setLocation(CourierFrame.w/6+40+(int)(16*6*1.07f), 128+80+100);
        
		JLabel l22 = new JLabel("寄件人手机：");
		l22.setSize((int)(16*6*1.07f), 16);
		l22.setFont(new Font("宋体", Font.BOLD, 15));
		l22.setLocation(CourierFrame.w/6+40, 128+80+120);
		phone1Label = new JLabel("15278313639");
		phone1Label.setSize((int)(16*6*1.07f), 16);
		phone1Label.setFont(new Font("宋体", Font.BOLD, 15));
		phone1Label.setForeground(Color.RED);
		phone1Label.setLocation(CourierFrame.w/6+40+(int)(16*6*1.07f), 128+80+120);

		JLabel l23 = new JLabel("寄件人地址：");
		l23.setSize((int)(16*6*1.07f), 16);
		l23.setFont(new Font("宋体", Font.BOLD, 15));
		l23.setLocation(CourierFrame.w/6+40, 128+80+140);
        add1Label = new JLabel("飒飒大苏打实打实大苏打大大大撒大大");
        add1Label.setSize((int)(16*44*1.07f), 16);
        add1Label.setFont(new Font("宋体", Font.BOLD, 15));
        add1Label.setForeground(Color.RED);
        add1Label.setLocation(CourierFrame.w/6+40+(int)(16*6*1.07f), 128+80+140);
        
        JLabel l24 = new JLabel("收件人姓名：");
		l24.setSize((int)(16*6*1.07f), 16);
		l24.setFont(new Font("宋体", Font.BOLD, 15));
        l24.setLocation(CourierFrame.w/6+40, 128+80+180);
        name2Label = new JLabel("实打实的");
        name2Label.setSize((int)(16*6*1.07f), 16);
        name2Label.setFont(new Font("宋体", Font.BOLD, 15));
        name2Label.setForeground(Color.RED);
        name2Label.setLocation(CourierFrame.w/6+40+(int)(16*6*1.07f), 128+80+180);
        
		JLabel l25 = new JLabel("收件人手机：");
		l25.setSize((int)(16*6*1.07f), 16);
		l25.setFont(new Font("宋体", Font.BOLD, 15));
		l25.setLocation(CourierFrame.w/6+40, 128+80+200);
		phone2Label = new JLabel("15278313639");
		phone2Label.setSize((int)(16*6*1.07f), 16);
		phone2Label.setFont(new Font("宋体", Font.BOLD, 15));
		phone2Label.setForeground(Color.RED);
		phone2Label.setLocation(CourierFrame.w/6+40+(int)(16*6*1.07f), 128+80+200);

		JLabel l26 = new JLabel("收件人地址：");
		l26.setSize((int)(16*6*1.07f), 16);
		l26.setFont(new Font("宋体", Font.BOLD, 15));
		l26.setLocation(CourierFrame.w/6+40, 128+80+220);
        add2Label = new JLabel("飒飒大苏打实打实大苏打大大大撒大大");
        add2Label.setSize((int)(16*44*1.07f), 16);
        add2Label.setFont(new Font("宋体", Font.BOLD, 15));
        add2Label.setForeground(Color.RED);
        add2Label.setLocation(CourierFrame.w/6+40+(int)(16*6*1.07f), 128+80+220);


		JLabel l7 = new JLabel("内件品名：");
		l7.setSize((int)(16*5*1.07f), 16);
		l7.setFont(new Font("宋体", Font.BOLD, 15));
		l7.setLocation(CourierFrame.w/6+40, 128+80+260);
		nameLabel = new JLabel("大保健");
		nameLabel.setSize((int)(16*8*1.07f), 16);
		nameLabel.setFont(new Font("宋体", Font.BOLD, 15));
		nameLabel.setForeground(Color.RED);
		nameLabel.setLocation(CourierFrame.w/6+40+(int)(16*5*1.07f), 128+80+260);

		JLabel l8 = new JLabel("重量(Kg)：");
		l8.setSize((int)(16*5*1.07f), 16);
		l8.setFont(new Font("宋体", Font.BOLD, 15));
		l8.setLocation(CourierFrame.w/6+40, 128+80+280);
		weightLabel = new JLabel("135.5");
		weightLabel.setSize((int)(16*6*1.07f), 16);
		weightLabel.setFont(new Font("宋体", Font.BOLD, 15));
		weightLabel.setForeground(Color.RED);
		weightLabel.setLocation(CourierFrame.w/6+40+(int)(16*5*1.07f), 128+80+280);
		
		JLabel ll = new JLabel("体积(m^3)：");
		ll.setSize((int)(16*6*1.07f), 16);
		ll.setFont(new Font("宋体", Font.BOLD, 15));
		ll.setLocation(CourierFrame.w/6+40, 128+80+300);
		vLabel = new JLabel("135.5");
		vLabel.setSize((int)(16*6*1.07f), 16);
		vLabel.setFont(new Font("宋体", Font.BOLD, 15));
		vLabel.setForeground(Color.RED);
		vLabel.setLocation(CourierFrame.w/6+40+(int)(16*6*1.07f), 128+80+300);

		JLabel l9 = new JLabel("运费：");
		l9.setSize((int)(16*3*1.07f), 16);
		l9.setFont(new Font("宋体", Font.BOLD, 15));
		l9.setLocation(CourierFrame.w/6+40, 128+80+320);
		priceLabel = new JLabel(135.5+"元");
		priceLabel.setSize((int)(16*6*1.07f), 16);
		priceLabel.setFont(new Font("宋体", Font.BOLD, 15));
		priceLabel.setForeground(Color.RED);
		priceLabel.setLocation(CourierFrame.w/6+40+(int)(16*3*1.07f), 128+80+320);

		JLabel l10 = new JLabel("寄件日期：");
		l10.setSize((int)(16*5*1.07f), 16);
		l10.setFont(new Font("宋体", Font.BOLD, 15));
		l10.setLocation(CourierFrame.w/6+40, 128+80+360);
		senddateLabel = new JLabel("大保健");
		senddateLabel.setSize((int)(16*8*1.07f), 16);
		senddateLabel.setFont(new Font("宋体", Font.BOLD, 15));
		senddateLabel.setForeground(Color.RED);
		senddateLabel.setLocation(CourierFrame.w/6+40+(int)(16*5*1.07f), 128+80+360);

        JLabel detail = new JLabel("物流详情");
        detail.setSize((int)(22*4*1.07f), 22);
        detail.setFont(new Font("宋体", Font.BOLD, 21));
        detail.setLocation(750, 128+80+50);
        
		//表头
		Vector<String> vColumns = new Vector<String>();
		vColumns.add("物流详情");
		//数据
		Vector<String> vData = new Vector<String>();
		ArrayList<String> sss= new ArrayList<String>();
		sss.add("2015-10-10 江苏南京撒大苏打大大撒十四说四十的撒大大大大大大大");
		sss.add("2015-10-10 江苏南京");
		sss.add("2015-10-10 江苏南京");
		//模型
		detailTableModel = new DefaultTableModel(vData, vColumns);
//		ArrayList<BankAccountVO> accountlist = bl.show();
//      for(int i =0 ; i<accountlist.size(); i++){
      for(int i =0 ; i<40; i++){
		Vector<String> v = new Vector<String>();
		String ss=sss.get(0);
		v.add(ss);
		detailTableModel.addRow(v);
        }
		//表格
		detailTable = new JTable(detailTableModel){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){
				return true;
			}
		};
		detailTable.setPreferredScrollableViewportSize(new Dimension(300,330));
		detailTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		detailTable.setSelectionBackground(Color.YELLOW);
		JPanel jp=new JPanel();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().add(detailTable);
		detailTable.setFillsViewportHeight(true);
		jp.setSize(320, 360);
		jp.setLocation(640, 128+80+70);
		jp.setOpaque(false);
		jp.add(scrollPane,BorderLayout.CENTER);
        


        search.setLocation(480,128+80-5);
		
		
        add(titleLabel);
        add(funLabel);
        add(currentuserLabel);
        add(currentusernameLabel);
    	
    	add(close);
    	add(min);
    	add(_return);
    	add(goto_SendPkg);
    	add(goto_ReceivePkg);
    	add(goto_SearchPkgInformation);

    	add(ordernum);
    	add(order);
    	add(search);

    	add(base);
    	add(l21);
    	add(name1Label);
    	add(l22);
    	add(phone1Label);
    	add(l23);
    	add(add1Label);
    	add(l24);
    	add(name2Label);
    	add(l25);
    	add(phone2Label);
    	add(l26);
    	add(add2Label);
    	
    	add(l7);
    	add(nameLabel);
    	add(l8);
    	add(weightLabel);
    	add(ll);
    	add(vLabel);
    	add(l9);
    	add(priceLabel);
    	add(l10);
    	add(senddateLabel);

    	add(detail);
    	add(jp);
	}

	private void _search(){
		
	}
	private void clear(){
		order.setText("");
		name1Label.setText("");
		phone1Label.setText("");
		add1Label.setText("");
		name2Label.setText("");
		phone2Label.setText("");
		add2Label.setText("");
		nameLabel.setText("");
		weightLabel.setText("");
		vLabel.setText("");
		priceLabel.setText("");
		senddateLabel.setText("");
		willprintMessage=false;
		repaint();
	}
	
	
	private void printMessage(String message, Color c){
		result=message;
		co=c;
		if(!willprintMessage){
			willprintMessage=true;
			repaint();
			new Thread(new Runnable(){
				public void run() {
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}

					willprintMessage=false;
					repaint();
				}
			}).start();
		}
	}
}
