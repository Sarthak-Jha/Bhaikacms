<template>
    <!-- <div class="container"> -->
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-8"><h2>User <b>Details</b></h2></div>
                    <div class="col-sm-4">
                        <div class="search-box">
                            <form @submit.prevent="handleSubmit()">
                                <input v-model="page.searchText" type="text" class="form-control" placeholder="Search here">
                            </form>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-12">
                        <table class="table table-striped table-hover table-bordered">
                            <thead>
                                <tr>
                                    <th style="cursor:pointer;" @click="sort('name')">User Name <i class="fa fa-sort"></i></th>
                                    <th style="cursor:pointer;" @click="sort('email')">User Email</th>
                                    <th style="cursor:pointer;" @click="sort('roleId')">Role<i class="fa fa-sort"></i></th>
                                    <th style="cursor:pointer;" @click="sort('isActive')">Is Active</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                
                                <UserListData  v-for="user in userList.content" :key="user.id" :data="user" :refresh="refresh"  /> 
                                <!-- <tr v-for="user in userList.content" :key="user.id">
                                     <td>
                                        <div v-if="!editing">
                                            <span class='text' @click="enableEditing(user.name)">{{user.name}}</span>
                                        </div>
                                        <div v-if="editing">
                                            <input v-model="user.name" class="input"/>
                                            <button @click="disableEditing"> Cancel </button>
                                            <button @click="saveEdit"> Save </button>
                                        </div>
                                    </td>
                                    <td><div class="editable-text">{{ user.name }}</div></td>
                                    <td>{{ user.email }}</td>
                                    <td>
                                        <div v-if="!editing">
                                            <span class='text' @click="enableEditing">{{chanegRoleName(user.roleId)}}</span>
                                        </div>
                                        <div v-if="editing">
                
                                            <select @change="checkToggleValue($event)">
                                                <option :value="user.roleId" @click="saveEdit" selected>{{chanegRoleName(user.roleId)}}</option>
                                                <option :value="toggleRoleId(user.role)">{{ toggleRoleName(user.roleId) }}</option>
                                            </select>
                                        </div>
                                    </td>
                                    <td>{{ changeIsActive(user.active) }}</td>
                                    <td v-if="user.active==1"><button @click="handleDelete(user.id)" class="btn btn-danger">Deactivae</button></td>
                                    <td v-if="user.active==0"><button @click="handleActivate(user.id)" class="btn btn-success">Activate</button></td>
                                </tr> -->
                            </tbody>
                        </table>
                </div>    
            </div>
            <div v-if="userList.totalElements!=0">
            <div class="clearfix">
                <!-- <div class="hint-text">Showing <b><span v-if="userList.number!=(userList.totalPages-1)">{{((page.pageNumber+1)*userList.numberOfElements)}}</span>
                    <span v-else>{{((userList.number*userList.size)+userList.numberOfElements)}}</span></b> out of <b>{{ userList.totalElements }}</b> entries</div>
                <!-- <div class="hint-text">Showing <b>{{ allAudits.size }}</b> out of <b>{{ allAudits.totalElements }}</b> entries</div> -->
                <!-- <ul class="pagination">
                    <button v-if="page.pageNumber!=0" @click="prvPage()"   class="btn btn-primary">Prev</button>
                    <span> {{page.pageNumber+1}} Out of {{userList.totalPages}}</span>
                    <button v-if="page.pageNumber!=(userList.totalPages-1)" @click="nextPage()" style="margin:10px;" class="btn btn-primary">Next</button>
                </ul> -->
                <div class="clearfix">
                <div class="hint-text">Showing <b>{{((userList.size)*userList.number)+1}} - 
                    <span v-if="userList.number!=(userList.totalPages-1)">{{(userList.size*(userList.number+1))}}</span>
                    <span v-else>{{ userList.totalElements }}</span>
                    </b> out of <b>{{ userList.totalElements }}</b> entries</div>
                <!-- <div class="hint-text">Showing <b>{{ allAudits.size }}</b> out of <b>{{ allAudits.totalElements }}</b> entries</div> -->
                <ul class="pagination">
                    Page:
                    <input style="width:60px;" type="number" v-model="currentPage"/>
                    <button style="margin:10px;" class="btn btn-success" v-if="currentPage<=userList.totalPages" @click="renderPage()">Go</button>
                    <button style="margin:10px;" class="btn btn-danger" v-else>Go</button>

                    <button v-if="page.pageNumber!=0" @click="prvPage()"   class="btn btn-primary">Prev</button>
                    <button v-if="page.pageNumber!=(userList.totalPages-1)" @click="nextPage()" style="margin:10px;" class="btn btn-primary">Next</button>
                </ul>
            </div>
            </div>
        </div>
        </div>
    <!-- </div> -->
</template>
<script src="./js/userList.js"></script>
<style scoped>
    .table-wrapper {
        background: #fff;
        padding:10px;
        margin: 0px 0;
        width:auto;
        height:100vh;
        box-shadow: 0 1px 1px rgba(0,0,0,.05);
    }
    .table-title {
        padding-bottom: 10px;
        margin: 0 0 10px;
    }
    .table-title h2 {
        margin: 8px 0 0;
        font-size: 22px;
    }
    .search-box {
        position: relative;        
        float: right;
    }
    .search-box input {
        height: 34px;
        border-radius: 20px;
        padding-left: 30px;
        border-color: #ddd;
        box-shadow: none;
    }
    .search-box input:focus {
        border-color: #3FBAE4;
    }
    table.table tr th, table.table tr td {
        border-color: #e9e9e9;
    }
    table.table-striped tbody tr:nth-of-type(odd) {
        background-color: #fcfcfc;
    }
    table.table-striped.table-hover tbody tr:hover {
        background: #f5f5f5;
    }
    table.table th i {
        font-size: 13px;
        margin: 0 5px;
        cursor: pointer;
    }
    table.table td:last-child {
        width: 130px;
    }
    table.table td a {
        color: #a0a5b1;
        display: inline-block;
        margin: 0 5px;
    }
    table.table td a.view {
        color: #03A9F4;
    }
    table.table td a.edit {
        color: #FFC107;
    }
    table.table td a.delete {
        color: #E34724;
    }
    table.table td i {
        font-size: 19px;
    }    
    .pagination {
        float: right;
        margin: 0 0 5px;
    }
    .pagination li a {
        border: none;
        font-size: 95%;
        width: 30px;
        height: 30px;
        color: #999;
        margin: 0 2px;
        line-height: 30px;
        border-radius: 30px !important;
        text-align: center;
        padding: 0;
    }
    .pagination li a:hover {
        color: #666;
    }   
    .pagination li.active a {
        background: #03A9F4;
    }
    .pagination li.active a:hover {        
        background: #0397d6;
    }
    .pagination li.disabled i {
        color: #ccc;
    }
    .pagination li i {
        font-size: 16px;
        padding-top: 6px
    }
    .hint-text {
        float: left;
        margin-top: 6px;
        font-size: 95%;
    }  
</style>
