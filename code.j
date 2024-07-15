package com.stockanalysis;

import com.stockanalysis.api.MarketstackAPI;
import com.stockanalysis.database.DatabaseManager;
import com.stockanalysis.analysis.HigherTimeFrameAnalyzer;
import com.stockanalysis.analysis.LowerTimeFrameAnalyzer;
import com.stockanalysis.ui.CLI;

public class Main {
    public static void main(String[] args) {
        MarketstackAPI api = new MarketstackAPI();
        DatabaseManager dbManager = new DatabaseManager();
        HigherTimeFrameAnalyzer htfAnalyzer = new HigherTimeFrameAnalyzer(dbManager);
        LowerTimeFrameAnalyzer ltfAnalyzer = new LowerTimeFrameAnalyzer(dbManager);
        CLI cli = new CLI(api, dbManager, htfAnalyzer, ltfAnalyzer);

        cli.start();
    }
}