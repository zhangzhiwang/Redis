-- while循环语句
local a=1;
local b=10;
while a<b do
print(a);
a=a+1;
end

print('----------------');

-- repeat循环语句
local c=1;
local d=10;
repeat
	print(c);
	c=c+1;
until c==d

print('-------------------');

-- 数字形式的for循环
local sum=0;
for i=1,100,1 do
sum=sum+i;
end
print(sum);
