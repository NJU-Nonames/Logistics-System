/**
 * 2015年11月15日
 *author:
 *description:
 */
package presentation.financialstafflowui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import businesslogic.financebl.BaseDataSettingBLImpl;
import businesslogicservice.financeblservice.BaseDataSettingBLService;
import presentation.img.Img;
import presentation.mainui.CurrentUser;
import presentation.mainui.MainFrame;
import presentation.mainui.MyButton;
import utility.Position;
import utility.ResultMessage;
import vo.BankAccountVO;
import vo.BaseAgencyVO;
import vo.RepertoryInfoVO;
import vo.StaffVO;
import vo.TruckVO;

/**期初建账
 * @author 谭期友
 *
 */
public class BaseDataSetting extends JPanel{

	private static final long serialVersionUID = -1194559040892610991L;
	private BaseDataSettingBLService bl;
	private FinacialStaffLowFrame frame;
	private CurrentUser currentUser;
	
	//最基本按钮
	private MyButton close;
	private MyButton min;
	private MyButton _return;
	//功能按钮

	private MyButton goto_CostManage;//成本管理
	private MyButton goto_SettlementManage;//结算管理
	private MyButton goto_Statistic;//统计报表
	private MyButton goto_BaseDataSetting;//期初建账
	private MyButton goto_SystemLog;//查看系统日志
	//详细操作按钮以及其他组件
	private MyButton confirm1;
	
	private JComboBox<String> listkind;
	private DefaultTableModel ListTableModel;
	private JTable ListTable;
	private JPanel jp;
	private DefaultTableModel ListTableModel2;
	private JTable ListTable2;
	private JPanel jp2;
	private DefaultTableModel ListTableModel3;
	private JTable ListTable3;
	private JPanel jp3;
	private DefaultTableModel ListTableModel4;
	private JTable ListTable4;
	private JPanel jp4;
	private DefaultTableModel ListTableModel5;
	private JTable ListTable5;
	private JPanel jp5;
	
	private int state;
	private int stated;
	private JPanel j;
	private CardLayout card;
	
	private boolean willprintMessage;//是否将要打印消息
	private String result;//打印的消息
	private Color co;//消息的颜色

	protected void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(Color.WHITE);
        g.drawImage(Img.BACKGROUND2, FinacialStaffLowFrame.w/6, FinacialStaffLowFrame.h/6, FinacialStaffLowFrame.w, FinacialStaffLowFrame.h, null);
        g.drawImage(Img.BACKGROUND1, FinacialStaffLowFrame.w/6, 0, FinacialStaffLowFrame.w, FinacialStaffLowFrame.h/6, null);
        g.drawImage(Img.BACKGROUND0, 0, 0, FinacialStaffLowFrame.w/6, FinacialStaffLowFrame.h, null);
        g.drawLine(FinacialStaffLowFrame.w/6-1, 0, FinacialStaffLowFrame.w/6-1, FinacialStaffLowFrame.h);
        g.drawLine(FinacialStaffLowFrame.w/6, 0, FinacialStaffLowFrame.w/6, FinacialStaffLowFrame.h);
        g.drawLine(FinacialStaffLowFrame.w/6+1, 0, FinacialStaffLowFrame.w/6+1, FinacialStaffLowFrame.h);
        g.drawLine(FinacialStaffLowFrame.w/6, FinacialStaffLowFrame.h/6, FinacialStaffLowFrame.w, FinacialStaffLowFrame.h/6);
        g.drawLine(FinacialStaffLowFrame.w/6, FinacialStaffLowFrame.h/6+1, FinacialStaffLowFrame.w, FinacialStaffLowFrame.h/6+1);
        
        if(willprintMessage){
        	g.drawImage(Img.BLACK_BG, 0, FinacialStaffLowFrame.h-50, FinacialStaffLowFrame.w, 50, null);
        	
            g.setColor(co);
            g.setFont(new Font("宋体", Font.BOLD, 26));
            g.drawString(result, -result.length()*13+FinacialStaffLowFrame.w/2, 13+FinacialStaffLowFrame.h-30);
        }
	}
	
	public BaseDataSetting(FinacialStaffLowFrame frame, CurrentUser currentUser){
		this.frame=frame;
		this.bl=new BaseDataSettingBLImpl();
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
    	goto_CostManage = new MyButton(frame.getWidth()/6, 30, Img.GOCHENGBEN_0, Img.GOCHENGBEN_1, Img.GOCHENGBEN_2);
    	goto_CostManage.addMouseListener(new MouseListener(){
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
    	goto_SettlementManage = new MyButton(frame.getWidth()/6, 30, Img.GOJIESUAN_0, Img.GOJIESUAN_1, Img.GOJIESUAN_2);
    	goto_SettlementManage.addMouseListener(new MouseListener(){
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
    	goto_Statistic = new MyButton(frame.getWidth()/6, 30, Img.GOTONGJIBAOBIAO_0,Img.GOTONGJIBAOBIAO_1,Img.GOTONGJIBAOBIAO_2);
    	goto_Statistic.addMouseListener(new MouseListener(){
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
    	goto_BaseDataSetting = new MyButton(frame.getWidth()/6, 30, Img.GOQICHU_2, Img.GOQICHU_2, Img.GOQICHU_2);
    	goto_BaseDataSetting.addMouseListener(new MouseListener(){
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
    	goto_SystemLog = new MyButton(frame.getWidth()/6, 30, Img.GOXITONG_0, Img.GOXITONG_1, Img.GOXITONG_2);
    	goto_SystemLog.addMouseListener(new MouseListener(){
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
    	//详细操作按钮
    	 confirm1 = new MyButton(90, 30, Img.CONFIRM_0, Img.CONFIRM_1, Img.CONFIRM_2);
         confirm1.addMouseListener(new MouseListener(){
 			public void mouseClicked(MouseEvent arg0) {
 				_confirm1();
 			}
 			public void mouseEntered(MouseEvent arg0) {}
 			public void mouseExited(MouseEvent arg0) {}
 			public void mousePressed(MouseEvent arg0) {}
 			public void mouseReleased(MouseEvent arg0) {}
         });
     	confirm1.setLocation(170+40+(int)(16*5*1.07f),128+80+20-7);
     	add(confirm1);
 		JLabel l1 = new JLabel("期初建账：");
 		l1.setSize((int)(16*5*1.07f), 16);
 		l1.setFont(new Font("宋体", Font.BOLD, 15));
 		l1.setLocation(170+40, 128+80+20);
 		add(l1);
 		
 		JLabel l2 = new JLabel("期初建账时间：");
 		l2.setSize((int)(16*7*1.07f), 16);
 		l2.setFont(new Font("宋体", Font.BOLD, 15));
 		l2.setLocation(170+40, 570);
 		add(l2);
 		JLabel l3 = new JLabel(bl.getInitTime());
 		l3.setSize((int)(16*12*1.07f), 16);
 		l3.setFont(new Font("宋体", Font.BOLD, 15));
         l3.setForeground(Color.RED);
 		l3.setLocation(170+40+(int)(16*7*1.07f), 570);
 		add(l3);
    	//最基本元素
        JLabel titleLabel = new JLabel("物流信息管理系统");
        titleLabel.setSize((int)(50*8*1.07f), 50);
        titleLabel.setFont(new Font("宋体", Font.BOLD, 50));
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setLocation(596-(int)(50*8*1.07f)/2,20);

        String func="期初建账";
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
    	
        card=new CardLayout();
		j = new JPanel();
		j.setSize(820, 290);
		j.setLocation(596-820/2, 128+80+50);
		j.setOpaque(false);
        j.setLayout(card);
        add(j);
        
		listkind=new JComboBox<String>();
		listkind.addItem("查看期初银行账户信息");
		listkind.addItem("查看期初机构信息");
		listkind.addItem("查看期初人员信息");
		listkind.addItem("查看期初车辆信息");
		listkind.addItem("查看期初库存信息");
		listkind.setSize(160, 20);
		listkind.setLocation(596+820/2-160-10, 128+80+20-3);
		listkind.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				clear();
				if(listkind.getSelectedItem().toString().compareTo("查看期初银行账户信息")==0){
					stated=state;
					state=1;
					int a;
					if(state-stated>0)
						a=state-stated;
					else
						a=state+5-stated;
					for(int i=0;i<a;i++)
						card.next(j);
				}else if(listkind.getSelectedItem().toString().compareTo("查看期初机构信息")==0){
					stated=state;state=2;int a;if(state-stated>0)a=state-stated;
					else a=state+5-stated;for(int i=0;i<a;i++)card.next(j);
				}else if(listkind.getSelectedItem().toString().compareTo("查看期初人员信息")==0){
					stated=state;state=3;int a;if(state-stated>0)a=state-stated;
					else a=state+5-stated;for(int i=0;i<a;i++)card.next(j);
				}else if(listkind.getSelectedItem().toString().compareTo("查看期初车辆信息")==0){
					stated=state;state=4;int a;if(state-stated>0)a=state-stated;
					else a=state+5-stated;for(int i=0;i<a;i++)card.next(j);
				}else if(listkind.getSelectedItem().toString().compareTo("查看期初库存信息")==0){
					stated=state;state=5;int a;if(state-stated>0)a=state-stated;
					else a=state+5-stated;for(int i=0;i<a;i++)card.next(j);
				}
			}
		});
		add(listkind);
		

		//表头
		Vector<String> vColumns = new Vector<String>();
		vColumns.add("用户名");
		vColumns.add("银行账号");
		vColumns.add("余额");
		//数据
		Vector<String> vData = new Vector<String>();
		//模型
		ListTableModel = new DefaultTableModel(vData, vColumns);
		ArrayList<BankAccountVO> accountlist = bl.findBaseAccount();
        for(int i =0 ; i<accountlist.size(); i++){
    		Vector<String> v = new Vector<String>();
    		v.add(accountlist.get(i).getName());
    		v.add(accountlist.get(i).getNumber());
    		v.add(""+accountlist.get(i).getMoney());
    		ListTableModel.addRow(v);
        }
		//表格
		ListTable = new JTable(ListTableModel){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){
				return false;//不能修改
			}
		};
		ListTable.setPreferredScrollableViewportSize(new Dimension(800,260));
		ListTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListTable.setSelectionBackground(Color.YELLOW);
		jp=new JPanel();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().add(ListTable);
		ListTable.setFillsViewportHeight(true);
      	ListTable.getTableHeader().setReorderingAllowed(false);
      	ListTable.getTableHeader().setResizingAllowed(false);
		jp.setOpaque(false);
		jp.add(scrollPane,BorderLayout.CENTER);
		j.add(jp);
		
		//表头
		Vector<String> vColumns2 = new Vector<String>();
		vColumns2.add("机构编号");
		vColumns2.add("机构名称");
		//数据
		Vector<String> vData2 = new Vector<String>();
		//模型
		ListTableModel2 = new DefaultTableModel(vData2, vColumns2);
		ArrayList<BaseAgencyVO> arr2 = bl.findBaseAgency();
        for(int i =0 ; i<arr2.size(); i++){
    		Vector<String> v = new Vector<String>();
    		v.add(arr2.get(i).AgencyNumber);
    		v.add(arr2.get(i).AgencyName);
    		ListTableModel2.addRow(v);
        }
		//表格
		ListTable2 = new JTable(ListTableModel2){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){
				return false;//不能修改
			}
		};
		ListTable2.setPreferredScrollableViewportSize(new Dimension(800,260));
		ListTable2.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListTable2.setSelectionBackground(Color.YELLOW);
		jp2=new JPanel();
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.getViewport().add(ListTable2);
		ListTable2.setFillsViewportHeight(true);
      	ListTable2.getTableHeader().setReorderingAllowed(false);
      	ListTable2.getTableHeader().setResizingAllowed(false);
		jp2.setOpaque(false);
		jp2.add(scrollPane2,BorderLayout.CENTER);
		j.add(jp2);

		//表头
		Vector<String> vColumns3 = new Vector<String>();
		vColumns3.add("姓名");
		vColumns3.add("性别");
		vColumns3.add("职位");
		vColumns3.add("身份证");
		vColumns3.add("工作起始时间");
		vColumns3.add("手机");
		vColumns3.add("所属机构名称");
		vColumns3.add("所属机构编号");
		//数据
		Vector<String> vData3 = new Vector<String>();
		//模型
		ListTableModel3 = new DefaultTableModel(vData3, vColumns3);
		ArrayList<StaffVO> arr3 = bl.findBaseStaff();
        for(int i =0 ; i<arr3.size(); i++){
    		Vector<String> v = new Vector<String>();
    		v.add(arr3.get(i).getName());
    		v.add(arr3.get(i).getSex());
    		if(arr3.get(i).getPostion()==Position.COURIER){
        		v.add("快递员");
    		}else if(arr3.get(i).getPostion()==Position.BUSINESS_OFFICE_CLERK){
    			v.add("营业厅业务员");
    		}else if(arr3.get(i).getPostion()==Position.CENTER_CLERK){
    			v.add("中转中心业务员");
    		}else if(arr3.get(i).getPostion()==Position.CENTER_REPERTORY_CLERK){
    			v.add("中转中心仓库管理员");
    		}else if(arr3.get(i).getPostion()==Position.FINANCIAL_STAFF_LOW){
    			v.add("低权限财务人员");
    		}else if(arr3.get(i).getPostion()==Position.FINANCIAL_STAFF_HIGH){
    			v.add("高权限财务人员");
    		}else if(arr3.get(i).getPostion()==Position.TOP_MANAGER){
    			v.add("总经理");
    		}else if(arr3.get(i).getPostion()==Position.ADMIN){
    			v.add("系统管理员");
    		}else if(arr3.get(i).getPostion()==Position.DRIVER){
    			v.add("司机");
    		}else if(arr3.get(i).getPostion()==Position.SUPERGOMAN){
    			v.add("押运员");
    		}else if(arr3.get(i).getPostion()==Position.GUARDMAN){
    			v.add("监督员");
    		}
    		v.add(arr3.get(i).getIDNum());
    		v.add(arr3.get(i).getWorkingtime());
    		v.add(arr3.get(i).getPhoneNum());
    		v.add(arr3.get(i).getAgencyName());
    		v.add(arr3.get(i).getAgencyId());
    		ListTableModel3.addRow(v);
        }
		//表格
		ListTable3 = new JTable(ListTableModel3){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){
				return false;//不能修改
			}
		};
		ListTable3.setPreferredScrollableViewportSize(new Dimension(800,260));
		ListTable3.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListTable3.setSelectionBackground(Color.YELLOW);
		jp3=new JPanel();
		JScrollPane scrollPane3 = new JScrollPane();
		scrollPane3.getViewport().add(ListTable3);
		ListTable3.setFillsViewportHeight(true);
	  	int[] width3={50,40,130,150,100,100,140,90};
	  	ListTable3.setColumnModel(getColumnModel(ListTable3,width3));
      	ListTable3.getTableHeader().setReorderingAllowed(false);
      	ListTable3.getTableHeader().setResizingAllowed(false);
		jp3.setOpaque(false);
		jp3.add(scrollPane3,BorderLayout.CENTER);
		j.add(jp3);
		//表头
		Vector<String> vColumns4 = new Vector<String>();
    	vColumns4.add("车辆代号");
    	vColumns4.add("车牌号");
    	vColumns4.add("服役时间");
		//数据
		Vector<String> vData4 = new Vector<String>();
		//模型
		ListTableModel4 = new DefaultTableModel(vData4, vColumns4);
		ArrayList<TruckVO> arr4 = bl.findBaseTruck();
        for(int i =0 ; i<arr4.size(); i++){
    		Vector<String> v = new Vector<String>();
    		v.add(arr4.get(i).getVehiclecode());
    		v.add(arr4.get(i).getPlatenumber());
    		v.add(arr4.get(i).getServiceTimeLimit());
    		ListTableModel4.addRow(v);
        }
		//表格
		ListTable4 = new JTable(ListTableModel4){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){
				return false;//不能修改
			}
		};
		ListTable4.setPreferredScrollableViewportSize(new Dimension(800,260));
		ListTable4.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListTable4.setSelectionBackground(Color.YELLOW);
		jp4=new JPanel();
		JScrollPane scrollPane4 = new JScrollPane();
		scrollPane4.getViewport().add(ListTable4);
		ListTable4.setFillsViewportHeight(true);
      	ListTable4.getTableHeader().setReorderingAllowed(false);
      	ListTable4.getTableHeader().setResizingAllowed(false);
		jp4.setOpaque(false);
		jp4.add(scrollPane4,BorderLayout.CENTER);
		j.add(jp4);
		//表头
		Vector<String> vColumns5 = new Vector<String>();
		vColumns5.add("仓库号");
		vColumns5.add("区");
		vColumns5.add("排");
		vColumns5.add("架");
		vColumns5.add("位");
		vColumns5.add("订单号");
		//数据
		Vector<String> vData5 = new Vector<String>();
		//模型
		ListTableModel5 = new DefaultTableModel(vData5, vColumns5);
		ArrayList<RepertoryInfoVO> arr5 = bl.findBaseRepertory();
        for(int i =0 ; i<arr5.size(); i++){
    		Vector<String> v = new Vector<String>();
    		v.add(arr5.get(i).getId());
    		v.add(arr5.get(i).getAreaNumber());
    		v.add(arr5.get(i).getRowNumber());
    		v.add(arr5.get(i).getFrameNumber());
    		v.add(arr5.get(i).getPlaceNumber());
    		v.add(arr5.get(i).getOrderId());
    		ListTableModel5.addRow(v);
        }
		//表格
		ListTable5 = new JTable(ListTableModel5){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){
				return false;//不能修改
			}
		};
		ListTable5.setPreferredScrollableViewportSize(new Dimension(800,260));
		ListTable5.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListTable5.setSelectionBackground(Color.YELLOW);
		jp5=new JPanel();
		JScrollPane scrollPane5 = new JScrollPane();
		scrollPane5.getViewport().add(ListTable5);
		ListTable5.setFillsViewportHeight(true);
	  	int[] width5={200,100,100,100,100,200};
	  	ListTable5.setColumnModel(getColumnModel(ListTable5,width5));
      	ListTable5.getTableHeader().setReorderingAllowed(false);
      	ListTable5.getTableHeader().setResizingAllowed(false);
		jp5.setOpaque(false);
		jp5.add(scrollPane5,BorderLayout.CENTER);
		j.add(jp5);
		
        //最基本按钮
    	close.setLocation(FinacialStaffLowFrame.w-30,0);
    	min.setLocation(FinacialStaffLowFrame.w-80,0);
    	_return.setLocation(20,50);
    	//功能按钮

    	goto_CostManage.setLocation(0,150);
    	goto_SettlementManage.setLocation(0,200);
    	goto_Statistic.setLocation(0,250);
    	goto_BaseDataSetting.setLocation(0,300);
    	goto_SystemLog.setLocation(0,350);
    	
    	//其他组件
        

    	add(titleLabel);
        add(funLabel);
        add(currentuserAgencyNameLabel);
        add(currentuserLabel);
        add(currentusernameLabel);
		
		
        add(titleLabel);
        add(funLabel);
        add(currentuserAgencyNameLabel);
        add(currentuserLabel);
        add(currentusernameLabel);
    	
    	add(close);
    	add(min);
    	add(_return);
    	add(goto_CostManage);
    	add(goto_SettlementManage);
    	add(goto_Statistic);
    	add(goto_BaseDataSetting);
    	add(goto_SystemLog);

    	
	}

	private void _confirm1(){
		ResultMessage resultMessage=bl.init();
		if(!resultMessage.isPass()){
			printMessage(resultMessage.getMessage(), Color.RED);
			return;
		}else{
			printMessage(resultMessage.getMessage(), Color.GREEN);
		}
	}
	private void clear(){
//		.setText("");
//		.setText("");
		willprintMessage=false;
		repaint();
	}
	private TableColumnModel getColumnModel(JTable repertoryTable, int[] width) {
		 TableColumnModel columns = repertoryTable.getColumnModel();  
		 for (int i = 0; i < width.length; i++) {  
			 TableColumn column = columns.getColumn(i);  
		     column.setPreferredWidth(width[i]);  
		 }  
		 return columns;
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
