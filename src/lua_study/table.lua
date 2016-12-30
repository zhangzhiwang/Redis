-- 表类型
local a={}; -- 定义一个空表并赋值给变量a
a['field']='value'; --给表添加元素，给该元素的field字段赋值value
print(a.field); -- 访问表中的元素方法一
print(a['field']); -- 访问表中的元素方法二，二者等效

local person={ -- 在定义表的时候添加元素
	name='zzw',
	age=27
};
print(person.age);
print(person['age']);

-- 当索引为整数时，表相当于数组
local b={};
b[1]='aaa';
b[2]='bbb';
print(b[1]);

local c={'Bob','John'};
print(c[1]);

print('------------------');

-- 通用形式for循环遍历数组（表的索引为整数）
for index,value in ipairs(c) do
	print(index);
	print(value);
end

print('--------------');

-- 数字形式for循环遍历数组
for i=1,#c do
	print(i);
	print(c[i]);
end

print('-----------------------');

-- 对于非数组的表的遍历用pairs()
local d={
	name='zzw';
	city='Beijing'
};

for i,v in pairs(d) do
	print(i);
	print(v);
end
