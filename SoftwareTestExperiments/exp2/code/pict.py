from random import randint

fileNum = [1,2,3,4,5,6,7,8,9,10]  #[文件数]
wordNum = [0,1,2,3,4,5,6,7,8,9]  #[每行最少单词数量]
charNum = [1,2,3,4,5,6,7]  #[每个单词最小字符数]
consecutiveWS = [1,2,3]  #[连续单词分隔符的数量]
wsType = [1,2,3]  #[单词分隔类型,1 2 3分别表示space tab both
lineFeeds = [0,1,2,3,4,5,6,7,8,9]  #[行数]
wsType_value = ["space", "tab", "both"]  #[生成的若干文本文件的文件名，命名格式为"配置编号_数字"]

def r_num(arr:list)->int:
    #print(randint(0, len(arr)-1))
    return arr[randint(0, len(arr)-1)]
        
with open("pict_output.txt", "w") as f:
    for i in range(0, 100):
        filenum = str(r_num(fileNum))
        wordnum = str(r_num(wordNum))
        charnum = str(r_num(charNum))
        consecutive_ws = str(r_num(consecutiveWS))
        ws_type = r_num(wsType)
        line_feeds = str(r_num(lineFeeds))
        ws_type_value = wsType_value[ws_type-1]
        f.write(filenum + " " + wordnum + " " + charnum + " " + consecutive_ws + " " + ws_type_value + " " + line_feeds + "\n")
