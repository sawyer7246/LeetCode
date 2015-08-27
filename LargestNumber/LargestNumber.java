
		  public static  String largestNumber(int[] nums) {
	          //利用桶排序的原理从高位到低位 按照Asic码值排序
			  int len = nums.length;
			  if(len==1)return ""+nums[0];
			  //先把int转成String的LinkedList
			  List<String> linkedArr = new LinkedList<String>();
			  for(int i = 0 ; i<len ; i++ ){
				  int tempEle = nums[i];
				  String tempStr =""+tempEle;
				  linkedArr.add(tempStr);
			  }
			  Collections.sort(linkedArr, new Comparator<String>(){
					@Override
					public int compare(String o1, String o2) {
						if(o2.equals(o1))return 0;
						//从最高位开始比较
						
						int len1 = o1.length();
						int len2 = o2.length();
						int comTimes =(o1.length()<=o2.length())?len1:len2;
						for(int j = 0 ; j<comTimes ;j++){
							if(o1.charAt(j)>o2.charAt(j)){
								return -1;
							}else if(o1.charAt(j)<o2.charAt(j)){
								return 1;
							}
						}
						if(len1==len2)return 0;
						if(len1<len2){
							//121 12  12 121
							if(o2.charAt(0)>o2.charAt(o1.length()))return -1;
							else if(o2.charAt(0)<o2.charAt(o1.length()))return 1;
							else return compare(o1,o2.substring(o1.length()));
						} else if(len1>len2){
							//121 12  12 121
							if(o1.charAt(0)>o1.charAt(o2.length()))return 1;
							else if(o1.charAt(0)<o1.charAt(o2.length()))return -1;
							else return compare(o1.substring(o2.length()),o2);
						}
						return 0;
					}
				  });
				
			  StringBuffer sb = new StringBuffer();
			  for( int k = 0 ; k<linkedArr.size() ; k++){
				  sb.append(linkedArr.get(k));
			  }
			  if(sb.charAt(0)=='0')return "0";
			  return sb.toString();
		    }