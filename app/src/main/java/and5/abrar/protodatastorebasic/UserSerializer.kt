package and5.abrar.protodatastorebasic

import androidx.datastore.CorruptionException
import androidx.datastore.Serializer
import com.google.protobuf.InvalidProtocolBufferException
import java.io.InputStream
import java.io.OutputStream

class UserSerializer: Serializer<UserPreferences> {
    override fun readFrom(input: InputStream): UserPreferences {
        try {
            return UserPreferences.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto.", exception)
        }
    }

    override fun writeTo(t: UserPreferences, output: OutputStream) {
        t.writeTo(output)
    }
}