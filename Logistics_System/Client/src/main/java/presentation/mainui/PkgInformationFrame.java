/**
 * 2015年11月20日
 *author:
 *description:
 */
package presentation.mainui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import presentation.img.Img;
import vo.OrderListVO;

/**
 * @author 谭期友
 *
 */
public class PkgInformationFrame extends JFrame{
	
	private static final long serialVersionUID = 4881080784503653011L;
	public static final int w = 450;
	public static final int h = 600;

	//面板对象
	Mypanel mypanel;
	private OrderListVO orderListVO;
	
	private boolean isDraging;//是否被拖住
	private int xx;
	private int yy;
	
	public PkgInformationFrame(OrderListVO orderListVO){
		this.setUndecorated(true);
		this.orderListVO=orderListVO;
		this.addMouseListener(new MouseAdapter() { 
			public void mousePressed(MouseEvent e) { 
				 isDraging = true; 
				 xx = e.getX(); 
				 yy = e.getY(); 
			}

			public void mouseReleased(MouseEvent e) { 
				 isDraging = false; 
			}
		});
		
		
		this.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) { 
			if (isDraging) { 
				 int left = getLocation().x; 
				 int top = getLocation().y; 
				 setLocation(left + e.getX() - xx, top + e.getY() - yy); 
			}
			}
		});
		this.setSize(w,h);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		isDraging=false;
		
		this.setIconImage(Img.MainICON);

		mypanel=new Mypanel();

		add(mypanel);
	}
	
	
	private class Mypanel extends JPanel{

		private static final long serialVersionUID = -1194559040892610991L;
		
		private MyButton confirm;
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

		protected void paintComponent(Graphics g){
	        super.paintComponent(g);
	        setBackground(Color.WHITE);
	        g.drawImage(Img.cao2, 0, -50, 1366, 768, null);
	        g.drawLine(10, 80, w-10, 80);
		}
		
		public Mypanel(){
			this.setLayout(null);

			//初始化组件
			initComponent();
		}
		private void initComponent() {
			confirm = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
			confirm.addMouseListener(new MouseListener(){
				public void mouseClicked(MouseEvent arg0) {
					PkgInformationFrame.this.dispose();
				}
				public void mouseEntered(MouseEvent arg0) {}
				public void mouseExited(MouseEvent arg0) {}
				public void mousePressed(MouseEvent arg0) {}
				public void mouseReleased(MouseEvent arg0) {}
	        });
	    	//最基本元素
	        JLabel titleLabel = new JLabel("物流信息查询");
	        titleLabel.setSize((int)(40*6*1.07f), 40);
	        titleLabel.setFont(new Font("宋体", Font.BOLD, 40));
	        titleLabel.setForeground(Color.BLACK);
	        titleLabel.setLocation(w/2-(int)(40*6*1.07f)/2,20);
	        
			confirm.setLocation(225-30/2,h-50);
			
			
			
			
			JLabel l21 = new JLabel("寄件人姓名：");
			l21.setSize((int)(16*6*1.07f), 16);
			l21.setFont(new Font("宋体", Font.BOLD, 15));
	        l21.setLocation(5, 85);
	        name1Label = new JLabel(orderListVO.getSenderName());
	        name1Label.setSize((int)(16*6*1.07f), 16);
	        name1Label.setFont(new Font("宋体", Font.BOLD, 15));
	        name1Label.setForeground(Color.RED);
	        name1Label.setLocation(5+(int)(16*6*1.07f), 85);
	        
			JLabel l22 = new JLabel("寄件人手机：");
			l22.setSize((int)(16*6*1.07f), 16);
			l22.setFont(new Font("宋体", Font.BOLD, 15));
			l22.setLocation(5, 85+16*1);
			phone1Label = new JLabel(orderListVO.getSenderTeleNumber());
			phone1Label.setSize((int)(16*6*1.07f), 16);
			phone1Label.setFont(new Font("宋体", Font.BOLD, 15));
			phone1Label.setForeground(Color.RED);
			phone1Label.setLocation(5+(int)(16*6*1.07f), 85+16*1);

			JLabel l23 = new JLabel("寄件人地址：");
			l23.setSize((int)(16*6*1.07f), 16);
			l23.setFont(new Font("宋体", Font.BOLD, 15));
			l23.setLocation(5, 85+16*2);
	        add1Label = new JLabel(orderListVO.getSenderAddress());
	        add1Label.setSize((int)(16*44*1.07f), 16);
	        add1Label.setFont(new Font("宋体", Font.BOLD, 15));
	        add1Label.setForeground(Color.RED);
	        add1Label.setLocation(5+(int)(16*6*1.07f), 85+16*2);
	        
	        JLabel l24 = new JLabel("收件人姓名：");
			l24.setSize((int)(16*6*1.07f), 16);
			l24.setFont(new Font("宋体", Font.BOLD, 15));
	        l24.setLocation(5, 85+16*3);
	        name2Label = new JLabel(orderListVO.getReceiverName());
	        name2Label.setSize((int)(16*6*1.07f), 16);
	        name2Label.setFont(new Font("宋体", Font.BOLD, 15));
	        name2Label.setForeground(Color.RED);
	        name2Label.setLocation(5+(int)(16*6*1.07f), 85+16*3);
	        
			JLabel l25 = new JLabel("收件人手机：");
			l25.setSize((int)(16*6*1.07f), 16);
			l25.setFont(new Font("宋体", Font.BOLD, 15));
			l25.setLocation(5, 85+16*4);
			phone2Label = new JLabel(orderListVO.getReceiverTeleNumber());
			phone2Label.setSize((int)(16*6*1.07f), 16);
			phone2Label.setFont(new Font("宋体", Font.BOLD, 15));
			phone2Label.setForeground(Color.RED);
			phone2Label.setLocation(5+(int)(16*6*1.07f), 85+16*4);

			JLabel l26 = new JLabel("收件人地址：");
			l26.setSize((int)(16*6*1.07f), 16);
			l26.setFont(new Font("宋体", Font.BOLD, 15));
			l26.setLocation(5, 85+16*5);
	        add2Label = new JLabel(orderListVO.getReceiverAddress());
	        add2Label.setSize((int)(16*44*1.07f), 16);
	        add2Label.setFont(new Font("宋体", Font.BOLD, 15));
	        add2Label.setForeground(Color.RED);
	        add2Label.setLocation(5+(int)(16*6*1.07f), 85+16*5);


			JLabel l7 = new JLabel("内件品名：");
			l7.setSize((int)(16*5*1.07f), 16);
			l7.setFont(new Font("宋体", Font.BOLD, 15));
			l7.setLocation(5, 85+16*6);
			nameLabel = new JLabel(orderListVO.getName());
			nameLabel.setSize((int)(16*8*1.07f), 16);
			nameLabel.setFont(new Font("宋体", Font.BOLD, 15));
			nameLabel.setForeground(Color.RED);
			nameLabel.setLocation(5+(int)(16*5*1.07f), 85+16*6);

			JLabel l8 = new JLabel("重量(Kg)：");
			l8.setSize((int)(16*5*1.07f), 16);
			l8.setFont(new Font("宋体", Font.BOLD, 15));
			l8.setLocation(5, 85+16*7);
			weightLabel = new JLabel(orderListVO.getWeight()+"");
			weightLabel.setSize((int)(16*6*1.07f), 16);
			weightLabel.setFont(new Font("宋体", Font.BOLD, 15));
			weightLabel.setForeground(Color.RED);
			weightLabel.setLocation(5+(int)(16*5*1.07f), 85+16*7);
			
			JLabel ll = new JLabel("体积(m^3)：");
			ll.setSize((int)(16*6*1.07f), 16);
			ll.setFont(new Font("宋体", Font.BOLD, 15));
			ll.setLocation(5, 85+16*8);
			vLabel = new JLabel(orderListVO.getVolume()+"");
			vLabel.setSize((int)(16*6*1.07f), 16);
			vLabel.setFont(new Font("宋体", Font.BOLD, 15));
			vLabel.setForeground(Color.RED);
			vLabel.setLocation(5+(int)(16*6*1.07f), 85+16*8);

			JLabel l9 = new JLabel("运费（元）：");
			l9.setSize((int)(16*6*1.07f), 16);
			l9.setFont(new Font("宋体", Font.BOLD, 15));
			l9.setLocation(5, 85+16*9);
			priceLabel = new JLabel(orderListVO.getPackPrice()+"");
			priceLabel.setSize((int)(16*6*1.07f), 16);
			priceLabel.setFont(new Font("宋体", Font.BOLD, 15));
			priceLabel.setForeground(Color.RED);
			priceLabel.setLocation(5+(int)(16*6*1.07f), 85+16*9);

			JLabel l10 = new JLabel("寄件时间：");
			l10.setSize((int)(16*5*1.07f), 16);
			l10.setFont(new Font("宋体", Font.BOLD, 15));
			l10.setLocation(5, 85+16*10);
			senddateLabel = new JLabel(orderListVO.getDepartTime());
			senddateLabel.setSize((int)(16*16*1.07f), 16);
			senddateLabel.setFont(new Font("宋体", Font.BOLD, 15));
			senddateLabel.setForeground(Color.RED);
			senddateLabel.setLocation(5+(int)(16*5*1.07f), 85+16*10);
			
			
			//表头
			Vector<String> vColumns = new Vector<String>();
			vColumns.add("物流详情");
			//数据
			Vector<String> vData = new Vector<String>();
			//模型
			detailTableModel = new DefaultTableModel(vData, vColumns);
			for(int i = 0 ; i<orderListVO.getPkgState().size(); i++){
				Vector<String> v = new Vector<String>();
	    		v.add(orderListVO.getPkgState().get(i));
	    		detailTableModel.addRow(v);
	        }
			//表格
			detailTable = new JTable(detailTableModel){
				private static final long serialVersionUID = 1L;

				public boolean isCellEditable(int row, int column){
					return true;
				}
			};
			detailTable.setPreferredScrollableViewportSize(new Dimension(400,250));
			detailTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			detailTable.setSelectionBackground(Color.YELLOW);
			JPanel jp=new JPanel();
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.getViewport().add(detailTable);
			detailTable.setFillsViewportHeight(true);
			jp.setSize(420, 280);
			jp.setLocation(225-420/2, 85+16*11);
			jp.setOpaque(false);
			jp.add(scrollPane,BorderLayout.CENTER);
			
			
	    	add(titleLabel);
	    	add(confirm);

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

	    	add(jp);
		}
	}
}
