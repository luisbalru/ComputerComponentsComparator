package com.example;

import java.io.BufferedReader;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;




public class EbayAsker implements FuenteDato{
	
	
	public String query(String request)
	{
		return getItem(request);
	}
	
	
	private String ReadBuffer(BufferedReader buffer) {  /// Get all placed in a buffer and stores it inside String
		String read = "";
		String line = "";
		try {
			while((line = buffer.readLine()) != null) {
				read += line;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return read;
	}
	public String getItem(String request)
	{
		String url = "https://api.sandbox.ebay.com/buy/browse/v1/item_summary/search?q=" + request + "&limit=5";
		HttpURLConnection connection;
		BufferedReader response;
		String res = "";
		try {
			
			connection = (HttpURLConnection) new URL( url ).openConnection();
			//connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
			connection.setRequestProperty("Authorization", "Bearer v^1.1#i^1#f^0#I^3#r^0#p^1#t^H4sIAAAAAAAAAOVXfWwURRTv9QsaPmy0fGiJnIuYQN292fvcW7kr1xbkwkdb7qilBGF2b7Zdurd72dmldybE84xoDCRGNFFICEY0SgQTQI00aOQPEkMl0agJEAwRRKIhBj+LacTZvaNcK4GzlEji/rOZmffevN/vvTdvBmSra+ZvXrL5jymOCeW7siBb7nCwk0BNdVXD1Iry+6rKQJGAY1f2wWxlruLCAgyTSopfiXBKUzFyppOKinl7MkSZusprEMuYV2ESYd4Q+Vhk+TLezQA+pWuGJmoK5Yy2hCjJFxQB63FzXiT6/IJEZtWrNuNaiPKBIPK5vdADPH6O87vJOsYmiqrYgKoRotyA5Wjgo90gzgZ4b4BnvQwLQBfl7EA6ljWViDCACtvu8rauXuTrjV2FGCPdIEaocDSyONYaibYsWhFf4CqyFS7wEDOgYeKRo2YtgZwdUDHRjbfBtjQfM0URYUy5wvkdRhrlI1edGYP7NtVeNxTcgSDnFVgOcoHguFC5WNOT0LixH9aMnKAlW5RHqiEbmZsxStgQNiDRKIxWEBPRFqf1azehIksy0kPUoqbI6khbGxVeLnebSIlrdLOWTJkG0ulYUyft9wegyImcQAsenyAJEipslLdWoHnUTs2ampAt0rBzhWY0IeI1Gs2Np4gbItSqtuoRybA8KpYLFjgEHNtlBTUfRdPoUa24oiQhwmkPbx6BYW3D0GWBABy2MHrBpihEwVRKTlCjF+1cLKRPGoeoHsNI8S5XX18f0+dhNL3b5QaAdXUuXxYTe1ASUkTWqvW8vHxzBVq2oYiIaGKZNzIp4kua5CpxQO2mwh6r1P0F3ke6FR49+4+JIsyukRUxXhUiQg8XRBzLeUXRC4PseFRIuJCkLssPJMAMnYR6LzJSChQRLZI8M5NIlxO8xye5PZyE6IQ/KNHeoCTRgi/hp1kJIYCQIIhB7v9UKKWmekzUUqhNU2QxMy4JP37JrifaoG5kmswMGceQopBfqbl/XajYgnobQVq1Pgaglg1MjMCUzFgZzoha0qVBcrRZU+tsr52lCLkEM8OQBMUG8SJBukvJSjJJEYYUSqJ0lXwZEgClq5CrS8IUDXujWwqkTNr8HZWrBHEeupzI92fGxs/gjSKjI6yZOrmaMK1Wu4prvUglxW/omqIgvYO9JSbGr1H9R03quqhERSY0rrvTkBWf/pW5cncJHWCM+Q2NOws563P7OQ/n9XhvCVezHdd45raewmOAt0TDRulH0r+4V7lGvvLCZfbH5hyHQc7xIXkoggCg2QYwr7piVWXFZAqTg5jBUE0IWpqRocRguVsljxgdMb0ok4KyXl7tWFP/Q+NQ0fty11owc/iFWVPBTip6boJZ11aq2LtmTGE54COXh4A3wHq7wJxrq5Xs9Mq62r4tMxyNvxw/tS86sb9m+0pVkaaBKcNCDkdVWWXOUfba/PrB4F8nj+inAv2PyusGz1edF+aWPXxxYzrquh8MzN0xKSe91VKz14d2z+T3nXxv20Cs7onJW7ZnjqYmf7Lsi/0Tvqw90r9nj7KJeqF11dZpP99z/gy88PhQuzLnTPtPtYfnzJvwzUMnD1Wcy/5Z9/zbHV9dWXLxgb7Lz/l6fj9+9t0LnY3vt3cd/PSVQ2LDidUL+/fvGGqf2PHsjOmPZb99x5x14Ni5ukt3b7jy9ZsffPTS4LaBS9/ldi49tvflhYNH3yh3rrmy/unG3mni62sHDpxY2fDjoQPqM9LHr6ablZ2exoObPhMvx8/+9muXjOrXn77YOTR07MXuRz5n0t9vmb303t2znd1P0U/WO6eezofxb5DcWY35DwAA");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setRequestMethod("POST");		
		
			connection.connect();	
		    //response = new BufferedReader(new InputStreamReader(connection.getInputStream()));		
			//res = ReadBuffer(response); 
			
			for(int i=0; i<20; i++) {
				System.out.println(connection.getHeaderField(i));
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return res;
	}
}