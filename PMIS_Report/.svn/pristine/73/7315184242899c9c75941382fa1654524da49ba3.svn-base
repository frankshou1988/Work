package com.tetrapak.action.ajax.cip;

import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.tetrapak.metaclass.CIPRealtimeData;
import com.tetrapak.model.cip.CIPRealtimeDataQueryActionModel;

public class CIPRealtimeDataQueryAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
    private List<CIPRealtimeData> cipRealtimeDataList;

    @JSON(name = "cipRealtimeDataList")
    public List<CIPRealtimeData> getCipRealtimeDataList() {
	return cipRealtimeDataList;
    }

    public void setCipRealtimeDataList(List<CIPRealtimeData> cipRealtimeDataList) {
	this.cipRealtimeDataList = cipRealtimeDataList;
    }

    public String execute() throws Exception {
	String result = INPUT;
	List<CIPRealtimeData> data = CIPRealtimeDataQueryActionModel.queryCIPRealtimeData();
	this.setCipRealtimeDataList(data);
	result = SUCCESS;
	return result;
    }

}
