# SettingGroupRecyclerView
![](https://github.com/dalancon/SettingGroupRecyclerView/tree/master/screenshots/WechatIMG104.jpeg)

实现app中设置页面的列表分组显示，原理自定义 ItemDecoration  
支持以下：  
1、控制第一行的头部和最后一行的底部的线条是否显示  
2、控制头部和尾部线条距离左边的距离  
3、灵活控制从哪些下标的地方开始分组  
4、中间行的线条高度  
5、中间行的线条距离左边的距离  
6、中间行的分割线的颜色  
7、组之间的区域颜色

```
MineItemDecoration mineItemDecoration = new MineItemDecoration(this)
                .setShowTopLine(true)
                .setShowBottomLine(false)
                .setDividerHeight(getResources().getDimensionPixelSize(R.dimen.divider_height))
                .setDividerMarginLeft(getResources().getDimensionPixelSize(R.dimen.divider_margin_left))
                .setSectionIndexs(2, 5)
                .setGroupDividerColor("#F2F2F2")
                .setDividerColor("#F4F4F4")
                .setTopAndBottomMarginLeft(getResources().getDimensionPixelSize(R.dimen.top_bottom_margin_left));

recyclerView.addItemDecoration(mineItemDecoration);
```


    /**
     * 设置分割线左边的距离
     *
     * @param divider_marginLeft
     */
    setDividerMarginLeft(int divider_marginLeft)

    /**
     * 设置分组的下标
     * @param indexs
     * @return
     */
    setSectionIndexs(Integer ...indexs)
      

    /**
     * 设置分割线的颜色
     * @param dividerColor
     * @return
     */
    setDividerColor(String dividerColor)

    /**
     * 设置组之间的区域颜色
     * @param groupDividerColor
     * @return
     */
    setGroupDividerColor(String groupDividerColor) 
    
    /**
     * 设置分割线高度
     *
     * @param dividerHeight
     */
    setDividerHeight(int dividerHeight) 

    setShowTopLine(boolean showTopLine) 

    setShowBottomLine(boolean showBottomLine)
    
    /**
     * 设置第一条上边和最后一条下边的线条距离左边的距离
     * @param topAndBottomMarginLeft
     * @return
     */
    setTopAndBottomMarginLeft(int topAndBottomMarginLeft)
