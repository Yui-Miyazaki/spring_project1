package com.example.demo.animalsAPI.repository;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.example.demo.animalsAPI.data.AnimalData;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class AnimalRepository {
	public AnimalData[] getAnimals() throws IOException {

		//APIのURL
		String url = "https://wsaz0e6z45.execute-api.ap-northeast-1.amazonaws.com/prod/animalsAPI";
//リクエスト送信の為にインスタンス生成
		RestTemplate rest = new RestTemplate();

		//RestTemplate の getForEntity メソッドで、指定された URL で GET を実行して、エンティティを取得
		ResponseEntity<String> response = rest.getForEntity(url, String.class);
System.out.println(response);
		//ResponseEntity の getBody メソッドで、先ほど取得したエンティティのレスポンスボディを取得
		String json = response.getBody();
		System.out.println(json);
		//readValueメソッドを使いたいからインスタンス化
		ObjectMapper mapper = new ObjectMapper();

		AnimalData[] animalsList = mapper.readValue(json, AnimalData[].class);

		return animalsList;
	}
	public AnimalData[] getAnimalDetail(String id) throws IOException {
		String url = "https://wsaz0e6z45.execute-api.ap-northeast-1.amazonaws.com/prod/animalsAPI?id=" + id;
		RestTemplate rest = new RestTemplate();
		ResponseEntity<String> response = rest.getForEntity(url, String.class);
		String json = response.getBody();
		System.out.println(json);
		ObjectMapper mapper = new ObjectMapper();

		AnimalData[] animalDetail = mapper.readValue(json, AnimalData[].class);

		return animalDetail;
	}
	}

