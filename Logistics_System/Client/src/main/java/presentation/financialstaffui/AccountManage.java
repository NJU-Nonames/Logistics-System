/**
 * 2015年11月15日
 *author:
 *description:
 */
package presentation.financialstaffui;

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
import javax.swing.JOptionPane;
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
	private FinacialStaffFrame frame;
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
        //g.drawImage(Img.BG, FinacialStaffFrame.w/6, 0, FinacialStaffFrame.w*5/6, FinacialStaffFrame.h, null);
        g.drawLine(FinacialStaffFrame.w/6, 10, FinacialStaffFrame.w/6, FinacialStaffFrame.h-10);
        g.drawLine(FinacialStaffFrame.w/6+10, FinacialStaffFrame.h/6, FinacialStaffFrame.w, FinacialStaffFrame.h/6);

        if(willprintMessage){
        	g.drawImage(Img.BLACK_BG, 0, FinacialStaffFrame.h-50, FinacialStaffFrame.w, 50, null);
        	
            g.setColor(co);
            g.setFont(new Font("宋体", Font.BOLD, 26));
            g.drawString(result, -result.length()*13+FinacialStaffFrame.w/2, 13+FinacialStaffFrame.h-30);
        }
	}
	
	public AccountManage(FinacialStaffFrame frame, AccountBLService bl, CurrentUser currentUser){
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
        goto_AccountManage = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
        goto_AccountManage.addMouseListener(new MouseListener(){
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
    	goto_CostManage = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
    	goto_CostManage.addMouseListener(new MouseListener(){
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
    	goto_SettlementManage = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
    	goto_SettlementManage.addMouseListener(new MouseListener(){
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
    	goto_Statistic = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
    	goto_Statistic.addMouseListener(new MouseListener(){
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
    	goto_BaseDataSetting = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
    	goto_BaseDataSetting.addMouseListener(new MouseListener(){
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
    	goto_SystemLog = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
    	goto_SystemLog.addMouseListener(new MouseListener(){
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
    	//最基本元素
        JLabel titleLabel = new JLabel("物流信息管理系统");
        titleLabel.setSize((int)(50*8*1.07f), 50);
        titleLabel.setFont(new Font("宋体", Font.BOLD, 50));
        titleLabel.setForeground(Color.BLUE);
        titleLabel.setLocation(596-(int)(50*8*1.07f)/2,20);

        String func="账户管理";
        JLabel funLabel = new JLabel(func);
        funLabel.setSize((int)(40*func.length()*1.07f), 40);
        funLabel.setFont(new Font("宋体", Font.BOLD, 40));
        funLabel.setLocation(596-(int)(40*func.length()*1.07f)/2,128+10);
        
        String s="财务人员";
        JLabel currentuserLabel = new JLabel(s);
        currentuserLabel.setSize((int)(30*s.length()*1.07f), 30);
        currentuserLabel.setFont(new Font("宋体", Font.BOLD, 30));
        currentuserLabel.setLocation(FinacialStaffFrame.w/6,128-30);
        
        JLabel currentusernameLabel = new JLabel(currentUser.getname());
        currentusernameLabel.setSize((int)(30*currentUser.getname().length()*1.07f), 30);
        currentusernameLabel.setFont(new Font("宋体", Font.BOLD, 30));
        currentusernameLabel.setForeground(Color.RED);
        currentusernameLabel.setLocation(FinacialStaffFrame.w/6+(int)(30*s.length()*1.07f),128-30);
    	//最基本按钮
    	close.setLocation(FinacialStaffFrame.w-30,0);
    	min.setLocation(FinacialStaffFrame.w-80,0);
    	_return.setLocation(20,50);
    	//功能按钮
    	goto_AccountManage.setLocation(20,150);
    	goto_CostManage.setLocation(20,200);
    	goto_SettlementManage.setLocation(20,250);
    	goto_Statistic.setLocation(20,300);
    	goto_BaseDataSetting.setLocation(20,350);
    	goto_SystemLog.setLocation(20,400);
    	
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
		Vector<BankAccountVO> vData = new Vector<BankAccountVO>();
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
		while(s.compareTo(Account)!=0){
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
			printMessage("请输入正确余额", Color.RED);
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
