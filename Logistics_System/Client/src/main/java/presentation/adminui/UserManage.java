/**
 * 2015年11月19日
 *author:
 *description:
 */
package presentation.adminui;

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

import businesslogic.userbl.UserManageBLImpl;
import businesslogicservice.userblservice.UserManageBLService;
import presentation.img.Img;
import presentation.mainui.CurrentUser;
import presentation.mainui.MainFrame;
import presentation.mainui.MyButton;
import utility.ResultMessage;
import utility.UserType;
import vo.DriverVO;
import vo.UserVO;

/**
 * @author 谭期友
 *
 */
public class UserManage extends JPanel{

	private static final long serialVersionUID = -1194559040892610991L;
	private UserManageBLService bl;
	private AdminFrame frame;
	private CurrentUser currentUser;
	
	//最基本按钮
	private MyButton close;
	private MyButton min;
	private MyButton _return;
	
	private MyButton add;
	private MyButton delete;
	private MyButton update;
	private MyButton search;
	
	private JTextField _admin= new JTextField();
	private JTextField _password= new JTextField();
	private JTextField _position= new JTextField();
	private JTextField _id= new JTextField();
	private JTextField searchField= new JTextField();

	//功能按钮
	private MyButton goto_UserManage;
	//详细操作按钮以及其他组件

	private boolean willprintMessage;//是否将要打印消息
	private String result;//打印的消息
	private Color co;//消息的颜色

	private DefaultTableModel userTableModel;
	private JTable userTable;
	
	protected void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(Color.WHITE);
        g.drawImage(Img.BACKGROUND2, AdminFrame.w/6, AdminFrame.h/6, AdminFrame.w, AdminFrame.h, null);
        g.drawImage(Img.BACKGROUND1, AdminFrame.w/6, 0, AdminFrame.w, AdminFrame.h/6, null);
        g.drawImage(Img.BACKGROUND0, 0, 0, AdminFrame.w/6, AdminFrame.h, null);
        g.drawLine(AdminFrame.w/6-1, 0, AdminFrame.w/6-1, AdminFrame.h);
        g.drawLine(AdminFrame.w/6, 0, AdminFrame.w/6, AdminFrame.h);
        g.drawLine(AdminFrame.w/6+1, 0, AdminFrame.w/6+1, AdminFrame.h);
        g.drawLine(AdminFrame.w/6, AdminFrame.h/6, AdminFrame.w, AdminFrame.h/6);
        g.drawLine(AdminFrame.w/6, AdminFrame.h/6+1, AdminFrame.w, AdminFrame.h/6+1);

        if(willprintMessage){
        	g.drawImage(Img.BLACK_BG, 0, AdminFrame.h-50, AdminFrame.w, 50, null);
        	
            g.setColor(co);
            g.setFont(new Font("宋体", Font.BOLD, 26));
            g.drawString(result, -result.length()*13+AdminFrame.w/2, 13+AdminFrame.h-30);
        }
	}
	
	public UserManage(AdminFrame frame, CurrentUser currentUser){
		this.frame=frame;
		this.bl=new UserManageBLImpl(currentUser);
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
        min = new MyButton(30, 30, Img.MINI_0, Img.MINI_1, Img.MINI_2);
        min.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				frame.setExtendedState(JFrame.ICONIFIED);
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
        _return = new MyButton(30, 30, Img.RETURN_0, Img.RETURN_1, Img.RETURN_2);
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
        goto_UserManage = new MyButton(30, 30, Img.GOYONGHU_2, Img.GOYONGHU_2, Img.GOYONGHU_2);
    	//详细操作按钮
    	
    	//最基本元素
        JLabel titleLabel = new JLabel("物流信息管理系统");
        titleLabel.setSize((int)(50*8*1.07f), 50);
        titleLabel.setFont(new Font("宋体", Font.BOLD, 50));
        titleLabel.setLocation(596-(int)(50*8*1.07f)/2,20);

        String func="用户管理";
        JLabel funLabel = new JLabel(func);
        funLabel.setSize((int)(40*func.length()*1.07f), 40);
        funLabel.setFont(new Font("宋体", Font.BOLD, 40));
        funLabel.setLocation(596-(int)(40*func.length()*1.07f)/2,128+10);

        String s="管理员";
        JLabel currentuserLabel = new JLabel(s);
        currentuserLabel.setSize((int)(30*s.length()*1.07f), 30);
        currentuserLabel.setFont(new Font("宋体", Font.BOLD, 30));
        currentuserLabel.setLocation(AdminFrame.w/6,128-30);
        
        JLabel currentusernameLabel = new JLabel(currentUser.getname());
        currentusernameLabel.setSize((int)(30*currentUser.getname().length()*1.07f), 30);
        currentusernameLabel.setFont(new Font("宋体", Font.BOLD, 30));
        currentusernameLabel.setForeground(Color.DARK_GRAY);
        currentusernameLabel.setLocation(AdminFrame.w/6+(int)(30*s.length()*1.07f),128-30);
    	//最基本按钮
    	close.setLocation(AdminFrame.w-30,0);
    	min.setLocation(AdminFrame.w-80,0);
    	_return.setLocation(20,50);
    	//功能按钮
    	goto_UserManage.setLocation(0,150);
    	
    	//其他组件
    	searchField.setSize(150, 20);
    	searchField.setLocation(AdminFrame.w/6+300,128+80);
    	
    	search = new MyButton(100, 30, Img.SEARCH_0, Img.SEARCH_1, Img.SEARCH_2);
    	search.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				_search();
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
    	search.setLocation(searchField.getX()+searchField.getWidth()+10,searchField.getY());
    	
    	Vector<String> vColumns = new Vector<String>();
    	vColumns.add("账号");
    	vColumns.add("密码");
    	vColumns.add("职位");
    	vColumns.add("工号");
    	
    	Vector<String> vData = new Vector<String>();

    	userTableModel = new DefaultTableModel(vData, vColumns);
    	ArrayList<UserVO> a = bl.showAll();
        for(int i =0 ; i<a.size(); i++){
    		Vector<String> v = new Vector<String>();
    		v.add(a.get(i).getAdmin());
    		
    		v.add(a.get(i).getPassword());
    		
    		switch(a.get(i).getPosition()){
    		case COURIER:v.add("快递员");break;
    		case BUSINESS_OFFICE_CLERK:v.add("营业厅业务员");break;
    		case CENTER_CLERK:v.add("中转中心业务员");break;
    		case CENTER_REPERTORY_CLERK:v.add("仓库管理员");break;
    		case FINANCIAL_STAFF_LOW:v.add("低级财务人员");break;
    		case FINANCIAL_STAFF_HIGH:v.add("高级财务人员");break;
    		case  TOP_MANAGER:v.add("总经理");break;
    		case ADMIN:v.add("管理员");break;
    		default :break;
    		}
    		
    		v.add(a.get(i).getId());
    		userTableModel.addRow(v);
        }

        userTable = new JTable(userTableModel){
    		private static final long serialVersionUID = 1L;

    		public boolean isCellEditable(int row, int column){
    			return false;//不能修改
    		}
    	};
    	userTable.setPreferredScrollableViewportSize(new Dimension(600,150));
    	userTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    	userTable.setSelectionBackground(Color.YELLOW);
    	JPanel jp=new JPanel();
    	JScrollPane scrollPane = new JScrollPane();
    	scrollPane.getViewport().add(userTable);
    	userTable.setFillsViewportHeight(true);
    	userTable.getTableHeader().setReorderingAllowed(false);
    	userTable.getTableHeader().setResizingAllowed(false);
		jp.setSize(680, 180);
		jp.setLocation(596-850/2+85, searchField.getY()+searchField.getHeight()+10);
    	jp.setOpaque(false);
    	jp.add(scrollPane,BorderLayout.CENTER);

    	JLabel admin = new JLabel("账号：");
    	admin.setSize((int)(16*"账号：".length()*1.07f), 16);
    	admin.setFont(new Font("宋体", Font.BOLD, 15));
    	admin.setLocation(AdminFrame.w/6+75,jp.getY()+jp.getHeight()+10);
        
    	_admin.setSize(150, 20);
    	_admin.setLocation(admin.getX()+admin.getWidth(),admin.getY());
    	
        JLabel password = new JLabel("密码：");
        password.setSize((int)(16*"密码：".length()*1.07f), 16);
        password.setFont(new Font("宋体", Font.BOLD, 15));
        password.setLocation(_admin.getX()+_admin.getWidth()+300,admin.getY());
        
        _password.setSize(150, 20);
    	_password.setLocation(password.getX()+password.getWidth(),password.getY());
    	
        JLabel position = new JLabel("职位：");
        position.setSize((int)(16*"职位：".length()*1.07f), 16);
        position.setFont(new Font("宋体", Font.BOLD, 15));
        position.setLocation(admin.getX(),admin.getY()+admin.getHeight()+10);
        
        _position.setSize(150, 20);
    	_position.setLocation(position.getX()+position.getWidth(),position.getY());
    	
        JLabel id = new JLabel("工号：");
        id.setSize((int)(16*"工号：".length()*1.07f), 16);
        id.setFont(new Font("宋体", Font.BOLD, 15));
        id.setLocation(_position.getX()+_position.getWidth()+300,position.getY());
        
        _id.setSize(150, 20);
    	_id.setLocation(id.getX()+id.getWidth(),id.getY());
    	
    	add = new MyButton(100, 30, Img.ADD_0, Img.ADD_1, Img.ADD_2);
        add.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				_add();
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
        add.setLocation(AdminFrame.w/6+75,position.getY()+position.getHeight()+10);
		
        update = new MyButton(100, 30, Img.UPDATE_0, Img.UPDATE_1, Img.UPDATE_2);
        update.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				_update();
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
        update.setLocation(add.getX()+add.getW()+200,add.getY());
        
        delete = new MyButton(100, 30, Img.DELETE_0, Img.DELETE_1, Img.DELETE_2);
        delete.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				_delete();
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
        delete.setLocation(update.getX()+update.getW()+200,add.getY());
        
        add(titleLabel);
        add(funLabel);
        add(currentuserLabel);
        add(currentusernameLabel);
    	
    	add(close);
    	add(min);
    	add(_return);
    	add(goto_UserManage);
    	add(add);
    	add(delete);
    	add(update);
    	add(search);
    	
    	add(admin);
    	add(password);
    	add(position);
    	add(id);
    	
    	add(_admin);
    	add(_password);
    	add(_position);
    	add(_id);
    	add(searchField);
    	
    	add(jp);
	}

	private void clear(){
		_admin.setText("");
		_password.setText("");
		_position.setText("");
		_id.setText("");
		searchField.setText("");
		willprintMessage=false;
		repaint();
	}
	private void _add(){
		String admin=_admin.getText();
		String password=_password.getText();
		String position=_position.getText();
		String id=_id.getText();
		if(admin.compareTo("")==0){
			printMessage("未输入账号！", Color.RED);
			return;
		}
		if(password.compareTo("")==0){
			printMessage("未输入密码！", Color.RED);
			return;
		}
		if(position.compareTo("")==0){
			printMessage("未输入职务！", Color.RED);
			return;
		}
		if(id.compareTo("")==0){
			printMessage("未输入工号！", Color.RED);
			return;
		}
		if(bl.findonAdmin(admin)!=null){
			printMessage("该账号已存在，无法添加！", Color.RED);
			return;
		}
		UserType type;
		switch(position){
		case "快递员":type=UserType.COURIER;break;
		case "营业厅业务员":type=UserType.BUSINESS_OFFICE_CLERK;break;
		case "中转中心业务员":type=UserType.CENTER_CLERK;break;
		case "仓库管理员":type=UserType.CENTER_REPERTORY_CLERK;break;
		case "低级财务人员":type=UserType.FINANCIAL_STAFF_LOW;break;
		case "高级财务人员":type=UserType.FINANCIAL_STAFF_HIGH;break;
		case "总经理":type=UserType.TOP_MANAGER;break;
		case "管理员":type=UserType.ADMIN;break;
		default :printMessage("职务输入有误，请重新输入！", Color.RED);return;
		}
		ResultMessage resultMessage = bl.addUser(new UserVO(admin, password, type, id));
		printMessage(resultMessage.getMessage(), Color.GREEN);
		clear();
		
		Vector<String> v = new Vector<String>();
		v.add(admin);		
		v.add(password);	
		v.add(position);
		v.add(id);
		
		userTableModel.addRow(v);
	}
	private void _delete(){
		int index = userTable.getSelectedRow();
		if(index == -1){
			printMessage("请选中一个用户！", Color.RED);
			return;
		}
		ResultMessage resultMessage = bl.removeUser((String)userTable.getValueAt(index, 0));
		printMessage(resultMessage.getMessage(), Color.GREEN);
		clear();
		userTableModel.removeRow(index);
	}
	private void _update(){
		String admin=_admin.getText();
		String password=_password.getText();
		String position=_position.getText();
		String id=_id.getText();
		if(admin.compareTo("")==0){
			printMessage("未输入账号！", Color.RED);
			return;
		}
		if(password.compareTo("")==0){
			printMessage("未输入密码！", Color.RED);
			return;
		}
		if(position.compareTo("")==0){
			printMessage("未输入职务！", Color.RED);
			return;
		}
		if(id.compareTo("")==0){
			printMessage("未输入工号！", Color.RED);
			return;
		}
		if(bl.findonAdmin(admin)==null){
			printMessage("该账号不存在，无法修改！", Color.RED);
			return;
		}
		
		UserType type;
		switch(position){
		case "快递员":type=UserType.COURIER;break;
		case "营业厅业务员":type=UserType.BUSINESS_OFFICE_CLERK;break;
		case "中转中心业务员":type=UserType.CENTER_CLERK;break;
		case "仓库管理员":type=UserType.CENTER_REPERTORY_CLERK;break;
		case "低级财务人员":type=UserType.FINANCIAL_STAFF_LOW;break;
		case "高级财务人员":type=UserType.FINANCIAL_STAFF_HIGH;break;
		case "总经理":type=UserType.TOP_MANAGER;break;
		case "管理员":type=UserType.ADMIN;break;
		default :printMessage("职务输入有误，请重新输入！", Color.RED);return;
		}		
		ResultMessage resultMessage = bl.updateUser(new UserVO(admin, password, type, id));
		printMessage(resultMessage.getMessage(), Color.GREEN);
		clear();
		int index=0;
		while(((String)userTable.getValueAt(index, 0)).compareTo(admin)!=0){
			index++;
		}
		userTable.setValueAt(admin, index, 0);
		userTable.setValueAt(password, index, 1);
		userTable.setValueAt(position, index, 2);
		userTable.setValueAt(id, index, 3);
		
		userTable.setRowSelectionInterval(index, index);
	}
	private void _search(){
		String admin=searchField.getText();
		if(admin.compareTo("")==0){
			printMessage("未输入账号！", Color.RED);
			return;
		}
		else{
			for(int i=0;i<userTable.getRowCount();i++){
				String s=(String) userTable.getValueAt(i, 0);
				if(s.compareTo(admin)==0){
					userTable.setRowSelectionInterval(i, i);
					return;
				}
			}
			printMessage("未搜索到该账号", Color.RED);
		}
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
