/**
 * 2015年11月15日
 *author:
 *description:
 */
package presentation.financialstaffhighui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import presentation.mainui.CheckFormat;
import presentation.mainui.CurrentUser;
import presentation.mainui.MainFrame;
import presentation.mainui.MyButton;
import utility.ResultMessage;
import vo.BankAccountVO;
import businesslogicservice.financeblservice.AccountBLService;

/**账户管理
 * @author 谭期友
 *
 */
public class AccountManage extends JPanel{

	private static final long serialVersionUID = -1194559040892610991L;
	private AccountBLService bl;
	private FinacialStaffHighFrame frame;
	private CurrentUser currentUser;
	
	//最基本按钮
	private MyButton close;
	private MyButton min;
	private MyButton _return;
	//功能按钮
	private MyButton goto_AccountManage;//账户管理
	private MyButton goto_CostManage;//成本管理
	private MyButton goto_SettlementManage;//结算管理
	private MyButton goto_Statistic;//统计报表
	private MyButton goto_BaseDataSetting;//期初建账
	private MyButton goto_SystemLog;//查看系统日志
	//详细操作按钮以及其他组件
	private MyButton search;
	private MyButton add;
	private MyButton remove;
	private MyButton change;
	
	
	private JTextField AccountField;//查找账户
	private DefaultTableModel AccountTableModel;//账户表格模型
	private JTable AccountTable;//账户表格
	private JTextField newAccountField;//新账户
	private JTextField newAccountBank;//新账户银行卡
	private JTextField yueField;//余额
	
	private boolean willprintMessage;//是否将要打印消息
	private String result;//打印的消息
	private Color co;//消息的颜色

	protected void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(Color.WHITE);
        g.drawImage(Img.BACKGROUND2, FinacialStaffHighFrame.w/6, FinacialStaffHighFrame.h/6, FinacialStaffHighFrame.w, FinacialStaffHighFrame.h, null);
        g.drawImage(Img.BACKGROUND1, FinacialStaffHighFrame.w/6, 0, FinacialStaffHighFrame.w, FinacialStaffHighFrame.h/6, null);
        g.drawImage(Img.BACKGROUND0, 0, 0, FinacialStaffHighFrame.w/6, FinacialStaffHighFrame.h, null);
        g.drawLine(FinacialStaffHighFrame.w/6-1, 0, FinacialStaffHighFrame.w/6-1, FinacialStaffHighFrame.h);
        g.drawLine(FinacialStaffHighFrame.w/6, 0, FinacialStaffHighFrame.w/6, FinacialStaffHighFrame.h);
        g.drawLine(FinacialStaffHighFrame.w/6+1, 0, FinacialStaffHighFrame.w/6+1, FinacialStaffHighFrame.h);
        g.drawLine(FinacialStaffHighFrame.w/6, FinacialStaffHighFrame.h/6, FinacialStaffHighFrame.w, FinacialStaffHighFrame.h/6);
        g.drawLine(FinacialStaffHighFrame.w/6, FinacialStaffHighFrame.h/6+1, FinacialStaffHighFrame.w, FinacialStaffHighFrame.h/6+1);
        
        if(willprintMessage){
        	g.drawImage(Img.BLACK_BG, 0, FinacialStaffHighFrame.h-50, FinacialStaffHighFrame.w, 50, null);
        	
            g.setColor(co);
            g.setFont(new Font("宋体", Font.BOLD, 26));
            g.drawString(result, -result.length()*13+FinacialStaffHighFrame.w/2, 13+FinacialStaffHighFrame.h-30);
        }
	}
	
	public AccountManage(FinacialStaffHighFrame frame, AccountBLService bl, CurrentUser currentUser){
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
        goto_AccountManage = new MyButton(frame.getWidth()/6, 30, Img.GOZHANGHU_2, Img.GOZHANGHU_2, Img.GOZHANGHU_2);
        goto_AccountManage.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				clear();
				frame.setStated(frame.getState());
				frame.setState(1);
				frame.change();
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
    	goto_CostManage = new MyButton(frame.getWidth()/6, 30, Img.GOCHENGBEN_0, Img.GOCHENGBEN_1, Img.GOCHENGBEN_2);
    	goto_CostManage.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				clear();
				frame.setStated(frame.getState());
				frame.setState(2);
				frame.change();
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
    	goto_SettlementManage = new MyButton(frame.getWidth()/6, 30, Img.GOJIESUAN_0, Img.GOJIESUAN_1, Img.GOJIESUAN_2);
    	goto_SettlementManage.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				clear();
				frame.setStated(frame.getState());
				frame.setState(3);
				frame.change();
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
    	goto_Statistic = new MyButton(frame.getWidth()/6, 30, Img.GOTONGJIBAOBIAO_0,Img.GOTONGJIBAOBIAO_1,Img.GOTONGJIBAOBIAO_2);
    	goto_Statistic.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				clear();
				frame.setStated(frame.getState());
				frame.setState(4);
				frame.change();
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
    	goto_BaseDataSetting = new MyButton(frame.getWidth()/6, 30, Img.GOQICHU_0, Img.GOQICHU_1, Img.GOQICHU_2);
    	goto_BaseDataSetting.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				clear();
				frame.setStated(frame.getState());
				frame.setState(5);
				frame.change();
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
    	goto_SystemLog = new MyButton(frame.getWidth()/6, 30, Img.GOXITONG_0, Img.GOXITONG_1, Img.GOXITONG_2);
    	goto_SystemLog.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				clear();
				frame.setStated(frame.getState());
				frame.setState(6);
				frame.change();
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
    	//详细操作按钮
    	search = new MyButton(90, 30, Img.SEARCH_0, Img.SEARCH_1, Img.SEARCH_2);
    	search.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				_search();
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
    	add = new MyButton(90, 30, Img.ADD_0, Img.ADD_1, Img.ADD_2);
    	add.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				_add();
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
    	remove = new MyButton(90, 30, Img.DELETE_0, Img.DELETE_1, Img.DELETE_2);
    	remove.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				_remove();
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
    	change = new MyButton(90, 30, Img.UPDATE_0, Img.UPDATE_1, Img.UPDATE_2);
    	change.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				_change();
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
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setLocation(596-(int)(50*8*1.07f)/2,20);

        String func="账户管理";
        JLabel funLabel = new JLabel(func);
        funLabel.setSize((int)(40*func.length()*1.07f), 40);
        funLabel.setFont(new Font("宋体", Font.BOLD, 40));
        funLabel.setLocation(596-(int)(40*func.length()*1.07f)/2,128+10);

        JLabel currentuserAgencyNameLabel = new JLabel(currentUser.getAgencyName());
        currentuserAgencyNameLabel.setSize((int)(30*currentUser.getAgencyName().length()*1.07f), 30);
        currentuserAgencyNameLabel.setFont(new Font("宋体", Font.BOLD, 30));
        currentuserAgencyNameLabel.setForeground(Color.DARK_GRAY);
        currentuserAgencyNameLabel.setLocation(170,128-30);
        
        String s="财务人员";
        JLabel currentuserLabel = new JLabel(s);
        currentuserLabel.setSize((int)(30*s.length()*1.07f), 30);
        currentuserLabel.setFont(new Font("宋体", Font.BOLD, 30));
        currentuserLabel.setLocation(170+(int)(30*currentUser.getAgencyName().length()*1.07f),128-30);
        
        JLabel currentusernameLabel = new JLabel(currentUser.getname());
        currentusernameLabel.setSize((int)(30*currentUser.getname().length()*1.07f), 30);
        currentusernameLabel.setFont(new Font("宋体", Font.BOLD, 30));
        currentusernameLabel.setForeground(Color.DARK_GRAY);
        currentusernameLabel.setLocation(170+(int)(30*currentUser.getAgencyName().length()*1.07f)+(int)(30*s.length()*1.07f),128-30);
    	//最基本按钮
    	close.setLocation(FinacialStaffHighFrame.w-30,0);
    	min.setLocation(FinacialStaffHighFrame.w-80,0);
    	_return.setLocation(20,50);
    	//功能按钮
    	goto_AccountManage.setLocation(0,150);
    	goto_CostManage.setLocation(0,200);
    	goto_SettlementManage.setLocation(0,250);
    	goto_Statistic.setLocation(0,300);
    	goto_BaseDataSetting.setLocation(0,350);
    	goto_SystemLog.setLocation(0,400);
    	
    	//其他组件
        JLabel AccountLabel = new JLabel("账户：");
        AccountLabel.setSize((int)(30*3*1.07f), 30);
        AccountLabel.setFont(new Font("宋体", Font.BOLD, 30));
        AccountLabel.setLocation(596-150,128+60);
        
        AccountField = new JTextField();
        AccountField.setSize(150, 30);
        AccountField.setLocation(596-50,128+60);
        
        search.setLocation(596+150,128+60);
        

        
		
		//表头
		Vector<String> vColumns = new Vector<String>();
		vColumns.add("用户名");
		vColumns.add("银行账号");
		vColumns.add("余额");
		//数据
		Vector<String> vData = new Vector<String>();
		//模型
		AccountTableModel = new DefaultTableModel(vData, vColumns);
		ArrayList<BankAccountVO> accountlist = bl.show();
        for(int i =0 ; i<accountlist.size(); i++){
    		Vector<String> v = new Vector<String>();
    		v.add(accountlist.get(i).getName());
    		v.add(accountlist.get(i).getNumber());
    		v.add(""+accountlist.get(i).getMoney());
        	AccountTableModel.addRow(v);
        }
		//表格
        AccountTable = new JTable(AccountTableModel){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){
				return false;//不能修改
			}
		};
		AccountTable.setPreferredScrollableViewportSize(new Dimension(480,150));
		AccountTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		AccountTable.setSelectionBackground(Color.YELLOW);
		JPanel jp=new JPanel();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().add(AccountTable);
		AccountTable.getTableHeader().setReorderingAllowed(false);
		AccountTable.getTableHeader().setResizingAllowed(false);
		AccountTable.setFillsViewportHeight(true);
		jp.setSize(500, 180);
		jp.setLocation(596-500/2, 128+120);
		jp.setOpaque(false);
		jp.add(scrollPane,BorderLayout.CENTER);

		JLabel l1 = new JLabel("新账户：");
		l1.setFont(new Font("宋体", Font.BOLD, 15));
        l1.setForeground(Color.BLACK);
		newAccountField = new JTextField(4);
		
		JLabel l2 = new JLabel("新卡号：");
		l2.setFont(new Font("宋体", Font.BOLD, 15));
        l2.setForeground(Color.BLACK);
		newAccountBank = new JTextField(14);
		
		JLabel l3 = new JLabel("余额：");
		l3.setFont(new Font("宋体", Font.BOLD, 15));
        l3.setForeground(Color.BLACK);
		yueField = new JTextField(8);
		
		JPanel jp2 = new JPanel();
		jp2.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp2.add(l1);
		jp2.add(newAccountField);
		jp2.add(l2);
		jp2.add(newAccountBank);
		jp2.add(l3);
		jp2.add(yueField);
		jp2.setOpaque(false);
		jp2.setSize(520, 30);
		jp2.setLocation(596-520/2, 128+340);

    	add.setLocation(596-15-200,128+420);
    	remove.setLocation(596-15,128+420);
    	change.setLocation(596-15+200,128+420);
    	
    	String tip="提示：若要修改账户，先选中表格一行，再在“新账户”里填入新账户名，最后点击按钮即可修改。";
        JLabel tipLabel = new JLabel(tip);
        tipLabel.setSize((int)(16*tip.length()*1.07f), 16);
        tipLabel.setFont(new Font("宋体", Font.BOLD, 15));
        tipLabel.setForeground(Color.RED);
        tipLabel.setLocation(596-(int)(15*tip.length()*1.07f)/2,128+490);

		
		
		
        add(titleLabel);
        add(funLabel);
        add(currentuserAgencyNameLabel);
        add(currentuserLabel);
        add(currentusernameLabel);
    	
    	add(close);
    	add(min);
    	add(_return);
    	add(goto_AccountManage);
    	add(goto_CostManage);
    	add(goto_SettlementManage);
    	add(goto_Statistic);
    	add(goto_BaseDataSetting);
    	add(goto_SystemLog);

    	add(AccountLabel);
    	add(AccountField);
    	add(search);
		add(jp);
		add(jp2);
		add(add);
		add(remove);
		add(change);
		add(tipLabel);
	}

	private void clear(){
		AccountField.setText("");
		newAccountField.setText("");
		newAccountBank.setText("");
		yueField.setText("");
		willprintMessage=false;
		repaint();
	}
	private void _search(){
		if(AccountField.getText().compareTo("")==0){
			printMessage("未输入账户！", Color.RED);
			return;
		}
		String Account = AccountField.getText();
		BankAccountVO bankAccountVO = bl.searchCount(Account);
		if(bankAccountVO==null){
			printMessage("查无此账户！", Color.RED);
			return;
		}
		int i=0;
		String s=(String) AccountTable.getValueAt(0, 0);
		while(s.compareTo(bankAccountVO.getName())!=0){
			i++;
			s=(String) AccountTable.getValueAt(i, 0);
		}
		AccountTable.setRowSelectionInterval(i, i);
	}
	private void _add(){
		String new_Account = newAccountField.getText();
		String new_AccountBank = newAccountBank.getText();
		double yue;
		try{
			yue = Double.parseDouble(yueField.getText());
		}catch(NumberFormatException e){
			printMessage("请输入正确余额！", Color.RED);
			return;
		}//接收数据完毕
		
		//格式检查
		result = CheckFormat.checkBankAccountNum(new_AccountBank);
		if(result.compareTo("格式正确")!=0){
			printMessage(result, Color.RED);
			return;
		}
		
		//ResultMessage检查
		BankAccountVO bankAccountVO=new BankAccountVO(new_Account, new_AccountBank, yue);
		ResultMessage resultMessage = bl.createCount(bankAccountVO);//已经写入数据库
		if(!resultMessage.isPass()){
			printMessage(resultMessage.getMessage(), Color.RED);
			return;
		}else{
			printMessage(resultMessage.getMessage(), Color.BLUE);
		}


		Vector<String> v = new Vector<String>();
		v.add(new_Account);
		v.add(new_AccountBank);
		v.add(yueField.getText());
		AccountTableModel.addRow(v);
		
		newAccountField.setText("");
		newAccountBank.setText("");
		yueField.setText("");
	}
	private void _remove(){
		int index = AccountTable.getSelectedRow();
		if(index == -1){
			printMessage("请选中一个账户！", Color.RED);
			return;
		}
		ResultMessage resultMessage = bl.removeCount((String) AccountTable.getValueAt(index, 0));
		printMessage(resultMessage.getMessage(), Color.GREEN);
		
		AccountTableModel.removeRow(index);//肯定能成功==
	}
	private void _change(){
		int index = AccountTable.getSelectedRow();
		if(index == -1){
			printMessage("请选中一个账户！", Color.RED);
			return;
		}
		if(newAccountField.getText().compareTo("")==0){
			printMessage("未输入新账户名！", Color.RED);
			return;
		}
		BankAccountVO countVo=new BankAccountVO(
				newAccountField.getText(),
				(String) AccountTable.getValueAt(index, 1),
				Double.parseDouble((String) AccountTable.getValueAt(index, 2)));
		ResultMessage resultMessage = bl.updateCount(countVo);//已更改
		printMessage(resultMessage.getMessage(), Color.GREEN);

		AccountTable.setValueAt((String)newAccountField.getText(), index, 0);
		newAccountField.setText("");
		newAccountBank.setText("");
		yueField.setText("");
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
