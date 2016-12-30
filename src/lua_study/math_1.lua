print(1+1)
print('10' + 1)
print(1==1)
print(1=='1') -- 不会进行类型转换
print({'a'} == {'a'})

-- 要比较字符串和数字的值，则必须进行显示类型转换
print(tonumber('1') == 1)
print(tostring(1) == '1')
print(tonumber('F',16) == 15) -- 将16进制的F转换成10进制
