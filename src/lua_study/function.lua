-- 函数
--function (i)
--	return i+1;
--end

-- 将函数赋值给一个局部变量
local a=function (i)
	return i+1;
end

-- 函数简化定义方式
local function b(i)
	return i+1;
end
--[[效果等同于：
local b=function (i)
	return i+1;
end
]]

-- 实参个数多于形参个数
local function c (i)
	print(i);
	return i+1;
end
c(1,2); -- 调用函数c

print('--------------------');

-- 实参个数少于形参个数
local function d(i,j)
	print(i);
	print(j);
end
d(1);

print('---------------------');

-- 可变参数
local function e(i,j,...)
	print(i);
	print(j);
	local args={...};
	print(#args);
	return unpack(args);
end
e(1,2,3,4);
print(e(1,2,3,4));

print('--------------');

-- unpack函数
local function f(...)
	local args={...};
	return unpack(args);
end
print(f(1,2,3));
