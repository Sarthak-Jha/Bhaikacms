import { mapGetters,mapActions } from "vuex";
import AutoComplete from "@/components/AutoComplete";
export default {
    name:'SideBar',
    data () {
        return {
            searchTerm:""
        }
    },
    computed: {
        ...mapGetters([
            'userDetails',
            'isLoggedIn'
        ])
    },
    components:{
        AutoComplete
      },
    methods:{
        ...mapActions([
            'AUTO_COMP'
          ]),
        pushToSearch() {
            this.$router.push({
                name:'search',
                query:{
                    searchTerm: this.searchTerm
                }
            })
        },
        autoComp() {
            this.AUTO_COMP(this.searchTerm)
        }
    }
}