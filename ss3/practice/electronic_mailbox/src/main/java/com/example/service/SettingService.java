package com.example.service;

import com.example.model.Setting;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SettingService {
    static final Map<Integer,Setting> settingList = new HashMap<>();
    static {
        settingList.put(1,new Setting("Settings","Languages","Page Size","Spams filter","Signature","Update","Cancel"));
        settingList.put(2,new Setting("Cài đặt","Ngôn ngữ","Kích thước trang","Lọc thư rác","Chữ Ký","Cập nhật","Hủy"));
        settingList.put(3,new Setting("設定","言語","ページサイズ","スパムフィルター","サイン","アップデート","キャンセル"));
        settingList.put(4,new Setting("设置","语言","页面大小","垃圾邮件过滤器","签名", "更新","取消"));
       }

      public Setting getSetting(int id){
        return settingList.get(id);
      }
}
