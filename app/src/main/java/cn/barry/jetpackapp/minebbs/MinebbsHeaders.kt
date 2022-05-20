package cn.barry.jetpackapp.minebbs
import cn.barry.jetpackapp.minebbs.model.ModelEntity
import kotlinx.coroutines.flow.Flow
import okhttp3.ResponseBody

/*************************
 * @Machine: RedmiBook Pro 15 Win11
 * @Path: minebbs/src/main/java/com/barry/minebbs
 * @Time: 2022/5/1 16:58
 * @Author: BarryAllen
 * @Description: MineBBS 别名文件
 **************************/

typealias TemplateEntity_Flow = Flow<ModelEntity.GET.TemplateEntity>
typealias TemplateEntity = ModelEntity.GET.TemplateEntity
typealias UserIconEntity_Flow = Flow<ResponseBody>
typealias UserIconEntity = ResponseBody