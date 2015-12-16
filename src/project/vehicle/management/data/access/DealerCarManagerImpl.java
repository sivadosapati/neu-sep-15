package project.vehicle.management.data.access;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import project.vehicle.management.ui.MainScreen;

public class DealerCarManagerImpl implements DealerCarManager {
	private File file;

	public DealerCarManagerImpl() {
		file = new File("dealers");
	}

	public String[] getDealerIds() {
		List<String> dealerIds = new ArrayList<String>();
		try {
			FileInputStream fis;
			fis = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);
			String thisLine = null;
			while ((thisLine = br.readLine()) != null) {
				String[] arr = thisLine.split("\t");
				String dealerId = arr[0];
				dealerIds.add(dealerId);
			}
			br.close();
		}catch (Exception e) {
			JOptionPane.showMessageDialog(new MainScreen(""), e.getMessage()+"\nPlease contact administrator to fix it!");
			System.exit(1);
			e.printStackTrace();
		}
		return dealerIds.toArray(new String[dealerIds.size()]);
	}

	public String[] getDealerIdsOld() {
		List<String> dealerIds = new ArrayList<String>();
		FileReadingTemplate template = new FileReadingTemplate() {

			@Override
			public void processLine(String line) {
				String[] arr = line.split("\t");
				String dealerId = arr[0];
				dealerIds.add(dealerId);

			}

		};
		template.setSkipFirstLine(false);
		try {
			template.parseFile(file);
		} catch (Exception e) {
		}
		return dealerIds.toArray(new String[dealerIds.size()]);
	}
}
