import { mapGetters, mapActions } from 'vuex'
import UserListData from '@/views/UserListData'
export default {
    name:'UserList',
    data() {
        return {
            page: {
                pageNumber:0,
                pageSize:10,
                sortBy:"",
                order:0,
            },
            deleteData : {
                idDelete:"",
                id:""
            },
            tempValue: null,
            editing: false,
            currentPage:1,
        }
    },
    components:{
        UserListData,
    },
    computed: {
        ...mapGetters([
            'userList',
            'userListEdit'
        ])
    },
    methods: {
        ...mapActions([
            'getUserList',
            'deleteUser',
            'searchUser'
        ]),
        init() {
            if(this.$session.get('roleId') === 0) {
                this.$router.push('/')
            }
            this.getUserList(this.page)
        },
        refresh () {
            // TODO
            // call api to fetch all data
            //this.init();
        },
        // chanegRoleName(roleId) {
        //     if (roleId === 0)
        //        return "User"
        //     else
        //        return "Admin"
        // },
        // checkToggleValue(event) {
        //     // check select change
        //     console.log('event', event.target)
        // }, 
        // changeIsActive(isActive) {
        //     if(isActive)
        //         return "Active"
        //     else
        //         return "Not active"
        // },
        nextPage() {
            if(this.page.pageNumber < this.userList.totalPages-1)
            {
                this.page.pageNumber = this.page.pageNumber+1
                this.currentPage = this.currentPage+1    
                this.page.pageSize = 10
                this.getUserList(this.page)
            }
        },
        prvPage() {
            if (this.page.pageNumber!=0) {
                this.page.pageNumber = this.page.pageNumber-1
                if(this.currentPage!=0)
                    this.currentPage = this.currentPage-1
                this.page.pageSize = 10
                this.getUserList(this.page)
            }
        },
        // handleDelete(id) {
        //     this.$swal({
        //         title: "Are you sure?",
        //         text: "",
        //         icon: "warning",
        //         buttons: true,
        //         dangerMode: true,
        //       }).then((willDelete) => {
        //         if (willDelete) {
        //             this.deleteData.idDelete = id
        //             this.deleteData.id = this.$session.get('userId')
        //             console.log(this.deleteData)
        //             this.deleteUser(this.deleteData).then( (resp) => {
        //             if(resp.deleted) {
        //                 this.$swal(resp.message)
        //                 this.getUserList(this.page)
        //             } else {
        //                 this.$swal('Not able to deactivae')
        //             }
        //             }).catch( (err) => {
        //                 console.log(err)
        //             })
        //         } else {
        //           this.$swal("Not deactivated");
        //         }
        //       })
        // },
        // handleActivate(id) {
        //     this.deleteData.idDelete = id
        //     this.deleteData.id = this.$session.get('userId')
        //     console.log(this.deleteData)
        //     this.deleteUser(this.deleteData).then( (resp) => {
        //     if(resp.deleted) {
        //         this.$swal(resp.message)
        //         this.getUserList(this.page)
        //     } else {
        //         this.$swal('Not able to activate')
        //     }
        //     }).catch( (err) => {
        //         console.log(err)
        //     })
        // },
        // enableEditing: function(value) {
        //     this.tempValue = value;
        //     this.editing = true;
        // },
        // disableEditing: function() {
        //     this.tempValue = null;
        //     this.editing = false;
        // },
        // saveEdit: function() {
        //     this.value = this.tempValue;
        //     this.disableEditing();
        //     //function call to save the details
        // },
        sort(name) {
            this.page.sortBy = name
            if(this.page.order==0)
               this.page.order=1
            else
               this.page.order=0
            this.getUserList(this.page)
        },
        handleSubmit() {
            this.searchUser(this.page)
        },
    },
    mounted() {
        this.init()
    }
}

