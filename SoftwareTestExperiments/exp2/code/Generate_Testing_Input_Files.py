from random import randint

words = [chr(i) for i in range(97,123)]

def GenerateTestingInputFiles(fileNum:int, wordNum:int, charNum:int, consecutiveWS:int, wsType:str, lineFeeds:int, fileNames:str)->int:
    """
    param:  fileNum       [文件数]
    param:  wordNum       [每行最少单词数量]
    param:  charNum       [每单词最小字符数]
    param:  consecutiveWS [连续单词分隔符]
    param:  wsType  [单词分隔符类型, 分别是and or is]
    param:  lineFeeds     [行的数量]
    param:  fileNames     [生成的若干文本文件的文件名，命名格式为“配置编号＋数字”，假设第5号配置有2个文件,则分别命名为5_1.txt 5_2.txt]

    return: file_sum      [生成文本文件的数量]
    """
    file_name = fileNames
    for i in range(0, fileNum):
        #使用配置号生成文件名
        with open(file_name + "_" + str(i) + ".txt", "w") as f:
            #保证生成的文件的行数
            print("lineFeeds: ", lineFeeds)
            for line_num in range(0, lineFeeds):
                line_str = ""
                #保证每行最少单词数量,随机附加0-9个单词;
                for word_th in range(0, wordNum + randint(0, 9)):
                    word = ""
                    for char_num in range(0, charNum):
                        word += words[randint(0, len(words)-1)]
                    line_str += word
                    #根据分隔符类型添加分隔符
                    if wsType == "space":
                        wsType_value = " "
                        line_str = line_str + wsType_value * consecutiveWS
                    elif wsType == "tab":
                        wsType_value = "\t"
                        line_str += wsType_value * consecutiveWS
                    elif wsType == "both":
                        wsType_value = [" ", "\t"]
                        for c in range(0, consecutiveWS):
                            line_str += wsType_value[randint(0,1)]
                #print("line_str: ", line_str)
                f.write(line_str + "\n")
    return fileNum

with open("pict_output.txt") as f:
    #生成文本数量
    sum_of_file = 0
    for num, line in enumerate(f.readlines()):
        #配置号
        num = num + 1
        line = line.strip("\n")
        config = line.split(" ")
        sum_of_file += GenerateTestingInputFiles(int(config[0]), int(config[1]), int(config[2]), int(config[3]), config[4], int(config[5]), str(num))
    print("总创建文件数：", sum_of_file)
