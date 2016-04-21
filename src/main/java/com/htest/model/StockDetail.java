package com.htest.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.sql.rowset.serial.SerialException;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;

@Entity
@Table(name = "stock_detail", catalog = "test")
public class StockDetail implements java.io.Serializable {

    private Integer stockId;
    private Stock stock;
    private String compName;
    private String compDesc;
    private String remark;
    private Date listedDate;
    private byte[] list;

    public StockDetail() {
    }

    public StockDetail(Stock stock, String compName, String compDesc,
                       String remark, Date listedDate) throws IOException {
        this.stock = stock;
        this.compName = compName;
        this.compDesc = compDesc;
        this.remark = remark;
        this.listedDate = listedDate;
        ArrayList<String> list = new ArrayList<String>();
        list.add("first");
        list.add("second");
        list.add("third");
        list.add("fourht");
        this.setListArrayList(list);
    }

    @GenericGenerator(name = "generator", strategy = "foreign",
            parameters = @Parameter(name = "property", value = "stock"))
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "STOCK_ID", unique = true, nullable = false)
    public Integer getStockId() {
        return this.stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    public Stock getStock() {
        return this.stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    @Column(name = "COMP_NAME", nullable = false, length = 100)
    public String getCompName() {
        return this.compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    @Column(name = "COMP_DESC", nullable = false)
    public String getCompDesc() {
        return this.compDesc;
    }

    public void setCompDesc(String compDesc) {
        this.compDesc = compDesc;
    }

    @Column(name = "REMARK", nullable = false)
    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "LISTED_DATE", nullable = false, length = 10)
    public Date getListedDate() {
        return this.listedDate;
    }

    public void setListedDate(Date listedDate) {
        this.listedDate = listedDate;
    }

    @Column(name = "LIST",columnDefinition = "LONGBLOB", nullable = false)
    public byte[] getList() {
        return list;
    }

    public void setList(byte[] list) {
        this.list = list;
    }

    public void setListArrayList(ArrayList<String> arrayList) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(baos);
        for (String element : arrayList) {
            out.writeUTF(element);
        }
        byte[] bytes = baos.toByteArray();
        this.list = bytes;
    }

    public ArrayList giveListAsArrayList() throws IOException {
        ArrayList<String> strings = new ArrayList<String>();
        ByteArrayInputStream bais = new ByteArrayInputStream(this.list);
        DataInputStream in = new DataInputStream(bais);
        while (in.available() > 0) {
            String element = in.readUTF();
            strings.add(element);
        }
        return strings;
    }

    @Override
    public String toString() {
        try {
            return "StockDetail{" +
                    "stockId=" + stockId +
                    ", compName='" + compName + '\'' +
                    ", compDesc='" + compDesc + '\'' +
                    ", remark='" + remark + '\'' +
                    ", listedDate=" + listedDate + "byte arr =" + this.giveListAsArrayList().toString() +
                    '}';
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}