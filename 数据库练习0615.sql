
-- create database 数据库名;
-- create table (一些字段)；

-- INSERT INTO `club` (`cid`, `cname`, `Logo`)
-- VALUES(1, 'Arsenal', 'https://cdn.sofifa.org/teams/2/light/1.png');

-- club 俱乐部表

-- 国籍表
select * from nation where nid = 52;
-- 球员表
select * from players limit 10;
-- 年龄最大小 10个人
select * from players order by age desc limit 10;
-- 查询能力值前十的球员信息 （overall） 只需要姓名，能力值
-- 查询球员姓名和国家信息（名称）
select pname, nation from players p, nation n
where p.nid = n.nid limit 10;
-- 查询球员姓名和俱乐部信息（名称）
select pname, cname from players p inner join 
club c on p.cid = c.cid;

-- 查询能力值后十的球员信息 包含其所在国家信息 
-- 球员名、国家名、能力值 普通连接查询

-- 查询能力值后十的球员信息 包含其所在俱乐部信息
-- 球员名、俱乐部名、能力值 inner join查询
-- 45
select max(age) as max_age from players;
-- 16
select min(age) as max_age from players;

-- 查询年龄最大的球员 （球员名字和年龄）
-- 查询年龄最小的球员 （球员名字和年龄）

select nid, count(*) as mem_count from players group by nid order by mem_count desc;

select * from nation where nid = 14

-- 查询平均年龄最大的俱乐部信息（包含cid、cname、avg_age即可）
-- inner/left/right join
select p.cid, cname, avg(age) as avg_age 
from players p left join club c on p.cid = c.cid
group by p.cid
order by avg_age desc;

--  查询俱乐部球员数，按从多到少排序（取前十即可， 无俱乐部的球员数量也需要显示）俱乐部ID、俱乐部名、球员数
select p.cid, cname, count(*) as players_count
from players p left join club c 
on p.cid = c.cid
group by p.cid
order by players_count desc;
-- 模糊搜索球员
select * from players where pname 
like '%name%' or 'name%' or '%name';

-- 最有潜力的10个球员（上升最大potential-overall）
select pname, age, photo, potential, overall, (potential-overall) as futuer from players order by futuer desc;  
