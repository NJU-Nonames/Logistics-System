/**
 * 2015年11月19日
 *author:
 *description:
 */
package presentation.businessofficeclerkui;

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

import businesslogicservice.logisticsblservice.TruckManageBLService;
import presentation.img.Img;
import presentation.mainui.CheckFormat;
import presentation.mainui.CurrentUser;
import presentation.mainui.MainFrame;
import presentation.mainui.MyButton;
import utility.ResultMessage;
import vo.TruckVO;

/**
 * @author 谭期友
 *
 */
public class TruckManage extends JPanel{

	private static final long serialVersionUID = -1194559040892610991L;
	private TruckManageBLService bl;
	private BusinessOfficeClerkFrame frame;
	private CurrentUser currentUser;
	
	//最基本按钮
	private MyButton close;
	private MyButton min;
	private MyButton _return;
	//功能按钮
	private MyButton goto_LoadManage;
	private MyButton goto_Receive;
	private MyButton goto_Deliver;
	private MyButton goto_CheckList;
	private MyButton goto_TruckManage;
	private MyButton goto_DriverManage;
	//详细操作按钮以及其他组件
	private MyButton add;
	private MyButton remove;
	private MyButton change;
	private MyButton search;
	
	private DefaultTableModel vehicleTableModel;
	private JTable vehicleTable;
	private JTextField vehiclecode;
	private JTextField platenumber;
	private JTextField serviceTimeLimit;

	private boolean willprintMessage;//是否将要打印消息
	private String result;//打印的消息
	private Color co;//消息的颜色

	protected void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(Color.WHITE);
        g.drawLine(BusinessOfficeClerkFrame.w/6, 10, BusinessOfficeClerkFrame.w/6, BusinessOfficeClerkFrame.h-10);
        g.drawLine(BusinessOfficeClerkFrame.w/6+10, BusinessOfficeClerkFrame.h/6, BusinessOfficeClerkFrame.w, BusinessOfficeClerkFrame.h/6);

        if(willprintMessage){
        	g.drawImage(Img.BLACK_BG, 0, BusinessOfficeClerkFrame.h-50, BusinessOfficeClerkFrame.w, 50, null);
        	
            g.setColor(co);
            g.setFont(new Font("宋体", Font.BOLD, 26));
            g.drawString(result, -result.length()*13+BusinessOfficeClerkFrame.w/2, 13+BusinessOfficeClerkFrame.h-30);
        }
	}
	
	public TruckManage(BusinessOfficeClerkFrame frame, TruckManageBLService bl, CurrentUser currentUser){
		this.frame=frame;
		this.bl=bl;
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
        goto_LoadManage = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
        goto_LoadManage.addMouseListener(new MouseListener(){
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
        goto_Receive = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
        goto_Receive.addMouseListener(new MouseListener(){
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
        goto_Deliver = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
        goto_Deliver.addMouseListener(new MouseListener(){
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
        goto_CheckList = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
        goto_CheckList.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				clear();
				frame.setStated(frame.getState());
				frame.setState(4);
				frame.setChanged(true);
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
        goto_TruckManage = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
        goto_TruckManage.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				clear();
				frame.setStated(frame.getState());
				frame.setState(5);
				frame.setChanged(true);
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
        goto_DriverManage = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
    	goto_DriverManage.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				clear();
				frame.setStated(frame.getState());
				frame.setState(6);
				frame.setChanged(true);
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
    	//详细操作按钮
    	add = new MyButton(30, 30, Img.BG, Img.CLOSE_1, Img.CLOSE_2);
    	add.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				_add();
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
    	remove = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
    	remove.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				_remove();
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
    	change = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
    	change.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				_change();
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
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
    	add.setLocation(170+20,128+290+40);
    	remove.setLocation(170+20+240,128+290+40);
    	change.setLocation(170+20+480,128+290+40);
    	search.setLocation(170+20+720,128+290+40);
    	
    	//最基本元素
        JLabel titleLabel = new JLabel("物流信息管理系统");
        titleLabel.setSize((int)(50*8*1.07f), 50);
        titleLabel.setFont(new Font("宋体", Font.BOLD, 50));
        titleLabel.setForeground(Color.BLUE);
        titleLabel.setLocation(596-(int)(50*8*1.07f)/2,20);

        String func="车辆信息管理";
        JLabel funLabel = new JLabel(func);
        funLabel.setSize((int)(40*func.length()*1.07f), 40);
        funLabel.setFont(new Font("宋体", Font.BOLD, 40));
        funLabel.setLocation(596-(int)(40*func.length()*1.07f)/2,128+10);

        JLabel currentuserAgencyNameLabel = new JLabel(currentUser.getAgencyName());
        currentuserAgencyNameLabel.setSize((int)(30*currentUser.getAgencyName().length()*1.07f), 30);
        currentuserAgencyNameLabel.setFont(new Font("宋体", Font.BOLD, 30));
        currentuserAgencyNameLabel.setForeground(Color.RED);
        currentuserAgencyNameLabel.setLocation(170,128-30);

        String s="营业厅业务员";
        JLabel currentuserLabel = new JLabel(s);
        currentuserLabel.setSize((int)(30*s.length()*1.07f), 30);
        currentuserLabel.setFont(new Font("宋体", Font.BOLD, 30));
        currentuserLabel.setLocation(170+(int)(30*currentUser.getAgencyName().length()*1.07f),128-30);
        
        JLabel currentusernameLabel = new JLabel(currentUser.getname());
        currentusernameLabel.setSize((int)(30*currentUser.getname().length()*1.07f), 30);
        currentusernameLabel.setFont(new Font("宋体", Font.BOLD, 30));
        currentusernameLabel.setForeground(Color.RED);
        currentusernameLabel.setLocation(170+(int)(30*currentUser.getAgencyName().length()*1.07f)+(int)(30*s.length()*1.07f),128-30);
    	//最基本按钮
    	close.setLocation(BusinessOfficeClerkFrame.w-30,0);
    	min.setLocation(BusinessOfficeClerkFrame.w-80,0);
    	_return.setLocation(20,50);
    	//功能按钮
    	goto_LoadManage.setLocation(20,150);
    	goto_Receive.setLocation(20,200);
    	goto_Deliver.setLocation(20,250);
    	goto_CheckList.setLocation(20,300);
    	goto_TruckManage.setLocation(20,350);
    	goto_DriverManage.setLocation(20,400);
    	
    	//其他组件
    	//表头
    	Vector<String> vColumns = new Vector<String>();
    	vColumns.add("车辆代号");
    	vColumns.add("车牌号");
    	vColumns.add("服役时间");
    	//数据
    	Vector<String> vData = new Vector<String>();
    	//模型
    	vehicleTableModel = new DefaultTableModel(vData, vColumns);
    	ArrayList<TruckVO> a = bl.show(currentUser.getAgencyNum());
        for(int i =0 ; i<a.size(); i++){
    		Vector<String> v = new Vector<String>();
    		v.add(a.get(i).getVehiclecode());
    		v.add(a.get(i).getPlatenumber());
    		v.add(a.get(i).getServiceTimeLimit());
    		vehicleTableModel.addRow(v);
        }
    	//表格
    	vehicleTable = new JTable(vehicleTableModel){
    		private static final long serialVersionUID = 1L;

    		public boolean isCellEditable(int row, int column){
    			return false;//不能修改
    		}
    	};
    	vehicleTable.setPreferredScrollableViewportSize(new Dimension(480,150));
    	vehicleTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    	vehicleTable.setSelectionBackground(Color.YELLOW);
    	JPanel jp=new JPanel();
    	JScrollPane scrollPane = new JScrollPane();
    	scrollPane.getViewport().add(vehicleTable);
    	vehicleTable.setFillsViewportHeight(true);
    	vehicleTable.getTableHeader().setReorderingAllowed(false);
    	vehicleTable.getTableHeader().setResizingAllowed(false);
		jp.setSize(500, 180);
		jp.setLocation(596-500/2, 128+80);
    	jp.setOpaque(false);
    	jp.add(scrollPane,BorderLayout.CENTER);

    	JLabel l1 = new JLabel("车辆代号：");
    	l1.setSize((int)(16*5*1.07f), 16);
    	l1.setFont(new Font("宋体", Font.BOLD, 15));
    	l1.setLocation(170+20, 128+290);
    	vehiclecode = new JTextField();
    	vehiclecode.setSize(150, 20);
    	vehiclecode.setLocation(170+20+(int)(16*5*1.07f), 128+290-3);
    	
    	JLabel l2 = new JLabel("车牌号：");
    	l2.setSize((int)(16*4*1.07f), 16);
    	l2.setFont(new Font("宋体", Font.BOLD, 15));
    	l2.setLocation(170+20+(int)(16*5*1.07f)+150, 128+290);
    	platenumber = new JTextField();
    	platenumber.setSize(150, 20);
    	platenumber.setLocation(170+20+(int)(16*5*1.07f)+150+(int)(16*4*1.07f), 128+290-3);
    	
    	JLabel l3 = new JLabel("开始服役时间：");
    	l3.setSize((int)(16*7*1.07f), 16);
    	l3.setFont(new Font("宋体", Font.BOLD, 15));
    	l3.setLocation(170+20+(int)(16*5*1.07f)+150+(int)(16*4*1.07f)+150, 128+290);
    	serviceTimeLimit = new JTextField();
    	serviceTimeLimit.setSize(150, 20);
    	serviceTimeLimit.setLocation(170+20+(int)(16*7*1.07f)+150+(int)(16*4*1.07f)+150+(int)(16*5*1.07f), 128+290-3);

    	String tip="查找：“车辆代号”里输入代号，再点击按钮即可查找";
        JLabel tipLabel = new JLabel(tip);
        tipLabel.setSize((int)(16*tip.length()*1.07f), 16);
        tipLabel.setFont(new Font("宋体", Font.BOLD, 15));
        tipLabel.setForeground(Color.RED);
        tipLabel.setLocation(596-(int)(15*tip.length()*1.07f)/2,128+290+120);
    	String tip2="修改：先选中一行，在“车辆代号”和“服役期至”里输入新信息，再点击按钮即可修改";
        JLabel tipLabel2 = new JLabel(tip2);
        tipLabel2.setSize((int)(16*tip2.length()*1.07f), 16);
        tipLabel2.setFont(new Font("宋体", Font.BOLD, 15));
        tipLabel2.setForeground(Color.RED);
        tipLabel2.setLocation(596-(int)(15*tip2.length()*1.07f)/2,128+290+120+40);
		
		
        add(titleLabel);
        add(funLabel);
        add(currentuserAgencyNameLabel);
        add(currentuserLabel);
        add(currentusernameLabel);
    	
    	add(close);
    	add(min);
    	add(_return);
    	add(goto_LoadManage);
    	add(goto_Receive);
    	add(goto_Deliver);
    	add(goto_CheckList);
    	add(goto_TruckManage);
    	add(goto_DriverManage);

    	add(jp);
    	add(l1);
    	add(vehiclecode);
    	add(l2);
    	add(platenumber);
    	add(l3);
    	add(serviceTimeLimit);
    	
    	add(add);
    	add(remove);
    	add(change);
    	add(search);

    	add(tipLabel);
    	add(tipLabel2);
	}

	private void _add(){
		String vehiclecode_s = vehiclecode.getText();
		String platenumber_s = platenumber.getText();
		String serviceTimeLimit_s = serviceTimeLimit.getText();

		if(vehiclecode_s.compareTo("")==0){
			printMessage("没有输入车辆代号！", Color.RED);
			return;
		}
		result = CheckFormat.checkTruckNum(vehiclecode_s);
		if(result.compareTo("格式正确")!=0){
			printMessage(result, Color.RED);
			return;
		}
		result = CheckFormat.checkTime(serviceTimeLimit_s);
		if(result.compareTo("格式正确")!=0){
			printMessage(result, Color.RED);
			return;
		}
		TruckVO truckVO=new TruckVO(vehiclecode_s, platenumber_s, serviceTimeLimit_s);
		ResultMessage resultMessage = bl.add(truckVO);
		if(!resultMessage.isPass()){
			printMessage(resultMessage.getMessage(), Color.RED);
			return;
		}else{
			printMessage(resultMessage.getMessage(), Color.BLUE);
		}

		Vector<String> v = new Vector<String>();
		v.add(vehiclecode_s);
		v.add(platenumber_s);
		v.add(truckVO.getServiceTimeLimit());
		vehicleTableModel.addRow(v);
		
		vehiclecode.setText("");
		platenumber.setText("");
		serviceTimeLimit.setText("");
	}
	private void _remove(){
		int index = vehicleTable.getSelectedRow();
		if(index == -1){
			printMessage("请选中一行！", Color.RED);
			return;
		}
		ResultMessage resultMessage = bl.delete(
				new TruckVO((String) vehicleTable.getValueAt(index, 0), 
						(String) vehicleTable.getValueAt(index, 1), 
						(String) vehicleTable.getValueAt(index, 2))
				);
		printMessage(resultMessage.getMessage(), Color.GREEN);
		vehicleTableModel.removeRow(index);
	}
	private void _change(){
		int index = vehicleTable.getSelectedRow();
		if(index == -1){
			printMessage("请选中一行！", Color.RED);
			return;
		}
		
		String vehiclecode_s = vehiclecode.getText();
		String serviceTimeLimit_s = serviceTimeLimit.getText();

		if(vehiclecode_s.compareTo("")==0){
			printMessage("没有输入车辆代号！", Color.RED);
			return;
		}
		result = CheckFormat.checkTime(serviceTimeLimit_s);
		if(result.compareTo("格式正确")!=0){
			printMessage(result, Color.RED);
			return;
		}
		
		TruckVO truckVO=new TruckVO(vehiclecode_s, 
				(String) vehicleTable.getValueAt(index, 1), 
				serviceTimeLimit_s);
		ResultMessage resultMessage = bl.update(truckVO);//已更改
		if(!resultMessage.isPass()){
			printMessage(resultMessage.getMessage(), Color.RED);
			return;
		}else{
			printMessage(resultMessage.getMessage(), Color.GREEN);
		}

		vehicleTable.setValueAt(vehiclecode_s, index, 0);
		vehicleTable.setValueAt(serviceTimeLimit_s, index, 2);
		vehiclecode.setText("");
		platenumber.setText("");
		serviceTimeLimit.setText("");
	}
	private void _search(){
		String vehiclecode_s = vehiclecode.getText();

		if(vehiclecode_s.compareTo("")==0){
			printMessage("没有输入车辆代号！", Color.RED);
			return;
		}
		
		TruckVO truckVO=bl.find(vehiclecode_s);
		if(truckVO==null){
			printMessage("查无此车辆！", Color.RED);
			return;
		}
		
		int i=0;
		String s=(String) vehicleTable.getValueAt(0, 0);
		while(s.compareTo(vehiclecode_s)!=0){
			i++;
			s=(String) vehicleTable.getValueAt(i, 0);
		}
		vehicleTable.setRowSelectionInterval(i, i);
	}
	private void clear(){
		vehiclecode.setText("");
		platenumber.setText("");
		serviceTimeLimit.setText("");
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
