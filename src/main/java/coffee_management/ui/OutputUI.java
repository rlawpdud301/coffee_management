package coffee_management.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import coffee_management.dto.Sale;
import coffee_management.service.OutputService;

public class OutputUI extends JFrame {

	private JPanel contentPane;
	private boolean isSale;
	private OutputService service;


	/**
	 * Create the frame.
	 */
	public OutputUI(boolean isSale) {
		service = new OutputService();
		this.isSale = isSale;
		setTitle(isSale ? "판매금액 순위" : "마진액 순위");
		initComponents();
	}


	private void initComponents() {
		setTitle("마진액 순위");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		List<Sale> list;
		try {
			list = service.outputOrder(isSale);
			
			RankListPanel panel = new RankListPanel();
			panel.setList(list);
			contentPane.add(panel, BorderLayout.CENTER);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
