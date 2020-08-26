import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {

        Workbook book = null;
        try {
            List<Customer> list = new ArrayList<Customer>();
            book = book.getWorkbook(new File("D:\\TESTExcel\\TEXT2.xls"));
            Sheet sheet = book.getSheet(1);

            for (int i = 0; i < sheet.getRows() - 1; i++) {
                Customer customer = new Customer();
                // 获取第一列第二行单元格对象
                Cell cell = sheet.getCell(0, i + 1);
                customer.setGonghao(cell.getContents());
                // 获取第二行其他数据
                customer.setName(sheet.getCell(1, i + 1).getContents());
                customer.setBumen(sheet.getCell(2, i + 1).getContents());
                customer.setData(sheet.getCell(3, i + 1).getContents());
                //5星期
                customer.setWeek(sheet.getCell(4, i + 1).getContents());
                //6最小上班班次
                customer.setNormalGoWorkData(sheet.getCell(5, i + 1).getContents());
                //7最大上班班次
                customer.setNoramlOutWorkData(sheet.getCell(6, i + 1).getContents());
                //8个人上班班次
                customer.setPersonalGoWorkData(sheet.getCell(7, i + 1).getContents());
                //9个人下班班次
                customer.setPersonalOutWorkData(sheet.getCell(8, i + 1).getContents());
                //10加班时长
                customer.setExtrnWorkTime(sheet.getCell(9, i + 1).getContents());
                //11上班异常
                customer.setAbnoramlGoWork(sheet.getCell(10, i + 1).getContents());
                //12下班异常
                customer.setAbnormalOutWork(sheet.getCell(11, i + 1).getContents());
                if (/*"出行研究院".equals(customer.getBumen())&& */!"星期日".equals(customer.getWeek())){
                    list.add(customer);
                }
            }
            int flag = 0;
            System.out.println("***************"+list.size());
            List<Customer> list2 = new ArrayList<Customer>();
            for (int i = 1; i < list.size()+1; i++) {
                int weiDaKaNum = 0;
                int halfHour = 0;
                int halfHourToTwo = 0;
                int moreThanTwo = 0;
                if (i%26 == 0 && i!=0){
                    list2.add(list.get(i-1));
                    // TODO 第一个人的开始做业务
                    for (Customer customer : list2) {
                        // 第一个人未打卡次数
                        if ("".equals(customer.getPersonalGoWorkData()) || "".equals(customer.getPersonalOutWorkData())
                                || customer.getPersonalGoWorkData().equals(customer.getPersonalOutWorkData())){
                            weiDaKaNum++;
                        }
                        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
                        //看着一天有没有问题
                        if ("1".equals(customer.getAbnoramlGoWork()) || "1".equals(customer.getAbnormalOutWork()) ){
                            // 有一种情况要排除，有打开时间但是上下班打卡时间一样的，已经按照忘打卡算，不再算迟到时间了
                          if (!customer.getPersonalGoWorkData().equals(customer.getPersonalOutWorkData())){
                              //有问题
                              long timeShangban = 0;
                              long timeXiaban = 0;
                              if ("1".equals(customer.getAbnoramlGoWork())){
                                  //上班有问题
                                  Date d1 = formatter.parse(customer.getPersonalGoWorkData());
                                  Date d2 = formatter.parse(customer.getNormalGoWorkData());
                                  long diff = d1.getTime() - d2.getTime();
                                  long days = diff / (1000 * 60 * 60 * 24);
                                  long hours = (diff-days*(1000 * 60 * 60 * 24))/(1000* 60 * 60);
                                  timeShangban = (diff-days*(1000 * 60 * 60 * 24)-hours*(1000* 60 * 60))/(1000* 60)+hours*60;
                              }
                              if ("1".equals(customer.getAbnormalOutWork())){
                                  //下班有问题
                                  Date d1 = formatter.parse(customer.getNoramlOutWorkData());
                                  Date d2 = formatter.parse(customer.getPersonalGoWorkData());
                                  long diff = d1.getTime() - d2.getTime();
                                  long days = diff / (1000 * 60 * 60 * 24);
                                  long hours = (diff-days*(1000 * 60 * 60 * 24))/(1000* 60 * 60);
                                  timeXiaban = (diff-days*(1000 * 60 * 60 * 24)-hours*(1000* 60 * 60))/(1000* 60)+hours*60;
                              }
                              if (timeShangban+timeXiaban<30){
                                  halfHour++;
                              }else if (timeShangban+timeXiaban>30 && timeShangban+timeXiaban<120){
                                  halfHourToTwo++;
                              }else {
                                  moreThanTwo++;
                              }
                          }

                        }
                        //todo 每个人每天
                        //System.out.println(customer.toString());
                    }
                     System.out.println("工号："+list.get(i-1).getGonghao()+"  姓名:"+list.get(i-1).getName()+" 未打卡次数:"+weiDaKaNum+"  迟到半小时内次数："+halfHour +" 迟到0.5-2.0小时内次数："+halfHourToTwo+"  迟到2小时以上次数："+moreThanTwo);
                    list2.clear();
                    halfHour = 0;
                    halfHourToTwo = 0;
                    moreThanTwo = 0;
                    continue;
                }
                list2.add(list.get(i-1));

            }



/*
            System.out.println("*********************"+list.size());

            for (Customer customer : list) {
                //业务 未打卡次数



                System.out.println(customer.toString());
            }*/

        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
}
