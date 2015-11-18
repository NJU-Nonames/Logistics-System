/**
 * 2015年11月15日
 *author:
 *description:
 */
package presentation.financialstaffui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import presentation.img.Img;
import presentation.mainui.MainFrame;
import presentation.mainui.MyButton;
import vo.UserVO;
import businesslogicservice.financeblservice.AccountBLService;
import businesslogicservice.userblservice.UserManageBLService;

/**账户管理
 * @author 谭期友
 *
 */
public class AccountManage extends JPanel{

	private static final long serialVersionUID = -1194559040892610991L;
	private AccountBLService bl;
	private FinacialStaffFrame frame;
	
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
	//详细操作按钮
	private MyButton search;
	private MyButton add;
	private MyButton remove;
	private MyButton change;
	
	
	private JTextField AccountField;
	
	private boolean Invalid;//输入是否非法
	String result;

	protected void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(Color.WHITE);
        g.drawLine(FinacialStaffFrame.w/6, 10, FinacialStaffFrame.w/6, FinacialStaffFrame.h-10);
        g.drawLine(FinacialStaffFrame.w/6+10, FinacialStaffFrame.h/6, FinacialStaffFrame.w, FinacialStaffFrame.h/6);
        
        if(Invalid){
        	g.drawImage(Img.BLACK_BG, 0, FinacialStaffFrame.h-50, FinacialStaffFrame.w, 50, null);
        	
            g.setColor(Color.RED);
            g.setFont(new Font("楷体", Font.BOLD, 26));
            g.drawString(result, -result.length()*13+FinacialStaffFrame.w/2, 13+FinacialStaffFrame.h-30);
        }
	}
	
	public AccountManage(FinacialStaffFrame frame, AccountBLService bl){
		this.frame=frame;
		this.bl=bl;
		Invalid=false;
		result="";
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
    	add = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
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
        titleLabel.setFont(new Font("楷体", Font.BOLD, 50));
        titleLabel.setLocation(596-(int)(50*8*1.07f)/2,20);

        JLabel funLabel = new JLabel("账户管理");
        funLabel.setSize((int)(40*4*1.07f), 40);
        funLabel.setFont(new Font("楷体", Font.BOLD, 40));
        funLabel.setLocation(596-(int)(40*4*1.07f)/2,128+10);
        
        String s="财务人员"+"张三";
        JLabel currentuserLabel = new JLabel(s);
        currentuserLabel.setSize((int)(30*s.length()*1.07f), 30);
        currentuserLabel.setFont(new Font("楷体", Font.BOLD, 30));
        currentuserLabel.setLocation(FinacialStaffFrame.w/6,128-30);
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
    	//其他
        JLabel AccountLabel = new JLabel("账户：");
        AccountLabel.setSize((int)(30*3*1.07f), 30);
        AccountLabel.setFont(new Font("楷体", Font.BOLD, 30));
        AccountLabel.setLocation(596-150,128+60);
        
        AccountField = new JTextField();
        AccountField.setSize(150, 30);
        AccountField.setLocation(596-50,128+60);
        
        search.setLocation(596+150,128+60);
        

        
    	

        add(titleLabel);
        add(funLabel);
        add(currentuserLabel);
    	
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
	}

	private void clear(){
//		.setText("");
//		.setText("");
		Invalid=false;
		repaint();
	}
	private void _search(){
	}
	private void _add(){
	}
	private void _remove(){
	}
	private void _change(){
	}
}
