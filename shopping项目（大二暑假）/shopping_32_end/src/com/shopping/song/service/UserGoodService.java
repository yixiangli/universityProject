package com.shopping.song.service;

import java.util.List;

import com.shopping.po.Goods;

public interface UserGoodService {
	 public List<Integer> showGidByUid(int uid);
	 public List<Goods> showGoodsByUid(int uid);
}
