<template>
  <div style="padding: 10px">

    <!-- 搜索框区域 -->

    <div style="margin: 10px 0">
      <el-input
        v-model="searchExamRoom"
        placeholder="请输入"
        clearable
        style="width: 20%"
      />
      <el-button type="primary" style="margin-left: 10px" @click="findExamRoomPage"
        >查询</el-button
      >
       <el-button type="primary" style="margin-right: 10px" @click="ToaddExamRoom">新增</el-button>

    </div>
    

    <!-- 表单区域开始 -->
    <el-table :data="tableData" border stripe style="width: 100%">
      <el-table-column
        prop="examRoomId"
        header-align="center"
        align="center"
        label="考场id">
       </el-table-column>
      <el-table-column
        prop="name"
        header-align="center"
        align="center"
        label="姓名">
       </el-table-column>
      <el-table-column
        prop="stuNum"
        header-align="center"
        align="center"
        label="学号">
       </el-table-column>
      <el-table-column
        prop="roomNum"
        header-align="center"
        align="center"
        label="考场号">
       </el-table-column>
      <el-table-column
        prop="examNum"
        header-align="center"
        align="center"
        label="考号">
       </el-table-column>
      <el-table-column
        prop="remarks"
        header-align="center"
        align="center"
        label="备注">
       </el-table-column>
      <el-table-column label="操作">
        <template #default="scope">
          <el-button size="small" @click="handleEdit(scope.row)"
            >编辑</el-button
          >
            <el-button size="mini" type="danger"  @click="handleDelete(scope.row.id)" >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 表单区域结束 -->

    <!-- 分页开始 -->
    <div style="margin: 10px">
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        v-model:currentPage="pageNum"
        :page-sizes="[5, 10, 20]"
        :page-size="pageSize"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total"
      ></el-pagination>
    </div>
    <!-- 分页结束 -->

    <!-- 添加用户的弹出框 -->
    <el-dialog v-model="dialogVisible" title="提示" width="30%">
      <!-- 添加用的表单界面 -->
      <el-form :model="form" label-width="120px">
	       <el-form-item label="考场id">
	          <el-input
	            v-model="form.examRoomId"
	            style="width: 80%"
	            placeholder="考场id"
	          ></el-input>
	        </el-form-item>
	       <el-form-item label="姓名">
	          <el-input
	            v-model="form.name"
	            style="width: 80%"
	            placeholder="姓名"
	          ></el-input>
	        </el-form-item>
	       <el-form-item label="学号">
	          <el-input
	            v-model="form.stuNum"
	            style="width: 80%"
	            placeholder="学号"
	          ></el-input>
	        </el-form-item>
	       <el-form-item label="考场号">
	          <el-input
	            v-model="form.roomNum"
	            style="width: 80%"
	            placeholder="考场号"
	          ></el-input>
	        </el-form-item>
	       <el-form-item label="考号">
	          <el-input
	            v-model="form.examNum"
	            style="width: 80%"
	            placeholder="考号"
	          ></el-input>
	        </el-form-item>
	       <el-form-item label="备注">
	          <el-input
	            v-model="form.remarks"
	            style="width: 80%"
	            placeholder="备注"
	          ></el-input>
	        </el-form-item>
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="dialogVisible = false">取 消</el-button>
          <el-button type="primary" @click="addExamRoom">确 定</el-button>
        </span>
      </template>
    </el-dialog>
    <!-- 添加用户的弹出框 结束 -->

    <!-- 修改用户的侧边框 开始 -->
    <el-dialog title="修改用户" v-model="dialogVisibleUp" :with-header="false">
      <el-form :model="form" label-width="120px">
	     <el-form-item label="考场id">
	          <el-input
	            v-model="form.examRoomId"
	            style="width: 80%"
	            placeholder="考场id"
	          ></el-input>
	     </el-form-item>
	     <el-form-item label="姓名">
	          <el-input
	            v-model="form.name"
	            style="width: 80%"
	            placeholder="姓名"
	          ></el-input>
	     </el-form-item>
	     <el-form-item label="学号">
	          <el-input
	            v-model="form.stuNum"
	            style="width: 80%"
	            placeholder="学号"
	          ></el-input>
	     </el-form-item>
	     <el-form-item label="考场号">
	          <el-input
	            v-model="form.roomNum"
	            style="width: 80%"
	            placeholder="考场号"
	          ></el-input>
	     </el-form-item>
	     <el-form-item label="考号">
	          <el-input
	            v-model="form.examNum"
	            style="width: 80%"
	            placeholder="考号"
	          ></el-input>
	     </el-form-item>
	     <el-form-item label="备注">
	          <el-input
	            v-model="form.remarks"
	            style="width: 80%"
	            placeholder="备注"
	          ></el-input>
	     </el-form-item>
        </el-form>
        <span
          class="dialog-footer"
          style="display: flex; margin: auto 0; justify-content: center"
        >
          <el-button @click="dialogVisibleUp = false">取 消</el-button>
          <!-- <el-button type="primary" @click="updateExamRoom">确 定</el-button> -->
          <el-button size="mini" type="success" @click="updateExamRoom" plain>确定</el-button>
        </span>
    </el-dialog>
    <!-- 编辑用户界面 结束 -->
  </div>
</template>

<script>
import request from "../../utils/request";
import { ElMessage, ElMessageBox } from 'element-plus'

export default {
  name: "ExamRoom",
  components: {},
  data() {
    return {
      searchExamRoom: "", //定义输入框
      currentPage: 1, //默认是1
      pageSize: 10, //默认为10
      pageNum: 1,
      total: 0,
      dialogVisible: false, //默认关闭 (添加用户弹出框)
      form: {}, //定义form对象为空
      tableData: [],
      sex: 0,
      dialogVisibleUp: false, //默认不显示抽屉
    };
  },
  //页面加载时
  created() {
    this.findExamRoomPage();
  },

  //方法写在data外面
  methods: {
    //查询所有用户
    findExamRoomPage() {
      console.log(this.searchExamRoom);
      request
        .get("/examRoom/findExamRoomPage", {
          params: {
            //传入变量
            pageSize: this.pageSize,
            pageNum: this.pageNum,
            name: this.searchExamRoom,
          },
        })
        .then((res) => {
          console.log(res);
          //重点 将查询到的数据records 返回给表单中的tableData
          (this.tableData = res.data.list), (this.total = res.data.total);
        });
    },

    //弹出添加用户框
    ToaddExamRoom() {
      //显示添加页面
      this.dialogVisible = true;
      //清空表单存在过的值
      this.form = {};
      // this.$me;
    },
    //添加用户操作
    addExamRoom() {
      request.post("/examRoom/addExamRoom/", this.form).then((res) => {
        if (res.result === 0) {
          this.$message({
            type: "success",
            message: "添加成功",
          });
        } else {
          this.$message({
            type: "error",
            message: res.message,
          });
        }
        //执行完了刷新界面
        this.findExamRoomPage();
        //关闭弹出框
        this.dialogVisible = false;
      });
    },

    //编辑拷贝
    handleEdit(row) {
      //深拷贝,避免取消了被改变
      this.form = JSON.parse(JSON.stringify(row));
      this.dialogVisibleUp = true;
    },
    //更新用户
    updateExamRoom() {
      ElMessageBox.confirm(
        '确认更新数据吗?',
        '提示',
        {
          confirmButtonText: '确认',
          cancelButtonText: '取消',
          type: 'Warning',
        }
      )
        .then(() => {
          request.put("/examRoom/updateExamRoom/", this.form).then((res) => {
            if (res.result === 0) {
              this.$message({
                type: "success",
                message: "更新成功",
              });
            } else {
              this.$message({
                type: "error",
                message: res.message,
              });
            }
            //执行完了刷新界面
            this.findExamRoomPage();
            //关闭弹出框
            this.dialogVisibleUp = false;
          });
        })
        .catch(() => {
          ElMessage({
            type: 'info',
            message: '更新取消',
          })
        })
      
    },

    //删除用户
    handleDelete(id) {
      ElMessageBox.confirm(
        '确认删除数据吗?',
        '提示',
        {
          confirmButtonText: '确认',
          cancelButtonText: '取消',
          type: 'Warning',
        }
      )
        .then(() => {
          request.put("/examRoom/deleteExamRoom/" + id).then((res) => {
          if (res.result === 0) {
            this.$message({
              type: "success",
              message: "删除成功",
            });
          } else {
            this.$message({
              type: "error",
              message: res.message,
            });
          }
          this.findExamRoomPage(); //重新加载删除之后表格的数据
        });
          })
        .catch(() => {
          ElMessage({
            type: 'info',
            message: '删除取消',
          })
        })

      
    },

    //改变条数
    handleSizeChange(pageSize) {
      this.pageSize = pageSize;
      this.findExamRoomPage();
    },

    //改变当前页码
    handleCurrentChange(pageNum) {
      this.pageNum = pageNum;
      this.findExamRoomPage();
    },
  },
};
</script>
